package com.ll.naengcipe.domain.fridge.fridge.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.fridge.fridge.dto.FridgeResponseDto;
import com.ll.naengcipe.domain.fridge.fridge.entity.Fridge;
import com.ll.naengcipe.domain.fridge.fridge.entity.FridgeIngredient;
import com.ll.naengcipe.domain.fridge.fridge.repository.FridgeIngredientRepository;
import com.ll.naengcipe.domain.fridge.fridge.repository.FridgeRepository;
import com.ll.naengcipe.domain.image.image.entity.Image;
import com.ll.naengcipe.domain.image.image.repository.ImageRepository;
import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;
import com.ll.naengcipe.domain.ingredient.ingredient.exception.IngredientNotExistException;
import com.ll.naengcipe.domain.ingredient.ingredient.repository.IngredientRepository;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FridgeService {

	private final RecipeRepository recipeRepository;
	private final FridgeRepository fridgeRepository;
	private final IngredientRepository ingredientRepository;
	private final FridgeIngredientRepository fridgeIngredientRepository;
	private final ImageRepository imageRepository;

	public Fridge findByUserId(Long id) {
		return fridgeRepository.findByMemberId(id);
	}

	public void save(Fridge userFridge) {
		fridgeRepository.save(userFridge);
	}

	@Transactional
	public FridgeResponseDto addIngredient(Long ingredientId, Long userId) {
		// 재료 찾기
		Ingredient ingredient = ingredientRepository.findById(ingredientId)
			.orElseThrow(() -> new NoSuchElementException("해당 재료가 존재하지 않습니다."));

		// 로그인 된 아이디의 냉장고 찾기
		Fridge userFridge = findByUserId(userId);

		userFridge.addIngredient(ingredient);

		return new FridgeResponseDto(userId, ingredient.getId(), ingredient.getName());
	}

	@Transactional
	public void removeIngredient(Long ingredientId, Long userId) {
		// 로그인 된 아이디의 냉장고 찾기
		Fridge userFridge = findByUserId(userId);

		FridgeIngredient fridgeIngredient = fridgeIngredientRepository.findByFridgeIdAndIngredientId(userFridge.getId(),
				ingredientId)
			.orElseThrow(() -> new NoSuchElementException("냉장고에 해당 재료가 존재하지 않습니다."));

		fridgeIngredientRepository.delete(fridgeIngredient);
	}

	public List<RecipeSearchResponseDto> findRecipesContainIngredients(List<Long> ingredientIds) {

		// 재료 찾기
		List<Ingredient> ingredients = ingredientRepository.findByIdIn(ingredientIds);
		//recipeCreateDto의 재료가 DB에 없으면 예외처리
		if (ingredientNotExist(ingredientIds.size(), ingredients.size())) {
			throw new IngredientNotExistException("해당 재료가 존재하지 않습니다.");
		}

		List<RecipeSearchResponseDto> recipeSearchDtos = recipeRepository.findRecipesByIngredients(ingredientIds);

		//DTO에 이미지 등록
		//TODO: 레시피 개수만큼 이미지 조회 쿼리를 전달하는 문제 해결
		for (RecipeSearchResponseDto recipeDto : recipeSearchDtos) {
			Image image = imageRepository.findFirstByRecipeId(recipeDto.getId());
			if (image != null) {
				recipeDto.setThumbnail(image.getUrl());
			}
		}

		return recipeSearchDtos;
	}

	private boolean
	ingredientNotExist(int requestIngredientSize, int size) {

		return size != requestIngredientSize;
	}
}
