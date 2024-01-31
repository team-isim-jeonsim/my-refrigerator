package com.ll.naengcipe.domain.fridge.fridge.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.fridge.fridge.entity.Fridge;
import com.ll.naengcipe.domain.fridge.fridge.repository.FridgeIngredientRepository;
import com.ll.naengcipe.domain.fridge.fridge.repository.FridgeRepository;
import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;
import com.ll.naengcipe.domain.ingredient.ingredient.repository.IngredientRepository;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;
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

	public Fridge findByUserId(Long id) {
		return fridgeRepository.findByMemberId(id);
	}

	public void save(Fridge userFridge) {
		fridgeRepository.save(userFridge);
	}

	@Transactional
	public void addIngredient(Long ingredientId, Long userId) {
		// 재료 찾기
		Ingredient ingredient = ingredientRepository.findById(ingredientId)
			.orElseThrow(() -> new NoSuchElementException("해당 재료가 존재하지 않습니다."));

		// 로그인 된 아이디의 냉장고 찾기
		Fridge userFridge = findByUserId(userId);

		userFridge.addIngredient(ingredient);
	}

	@Transactional
	public void removeIngredient(Long ingredientId, Long userId) {
		// 재료 찾기
		Ingredient ingredient = ingredientRepository.findById(ingredientId)
			.orElseThrow(() -> new NoSuchElementException("해당 재료가 존재하지 않습니다."));

		// 로그인 된 아이디의 냉장고 찾기
		Fridge userFridge = findByUserId(userId);

		userFridge.removeIngredient(ingredient);
	}

	public List<RecipeSearchResponseDto> findRecipesContainIngredients(List<Long> ingredients) {

		return recipeRepository.findRecipesByIngredients(ingredients);
	}
}
