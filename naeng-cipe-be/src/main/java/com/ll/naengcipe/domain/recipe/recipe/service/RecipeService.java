package com.ll.naengcipe.domain.recipe.recipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeInfoResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.entity.RecipeIngredient;
import com.ll.naengcipe.domain.recipe.recipe.exception.RecipeNotFoundException;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeInfoResponseDto findRecipe(Long recipeId) {
		// 1. 레시피 아이디가 유효한 아이디인지 확인
		Recipe recipe = recipeRepository.findByIdWithRecipeIngredient(recipeId)
			.orElseThrow(() -> new RecipeNotFoundException("해당 재료를 찾을 수 없습니다."));

		List<RecipeIngredient> recipeIngredients = recipe.getRecipeIngredient();
		List<IngredientResponseDto> IngredientDtos = recipeIngredients.stream()
			.map(ri -> IngredientResponseDto.toDto(ri.getIngredient()))
			.collect(Collectors.toList());

		// 2. 유효한 아이디일 경우 레시피 정보 조회
		RecipeInfoResponseDto recipeInfoResponseDto = new RecipeInfoResponseDto();
		recipeInfoResponseDto.setId(recipe.getId());
		recipeInfoResponseDto.setTitle(recipe.getTitle());
		recipeInfoResponseDto.setContent(recipe.getContent());
		recipeInfoResponseDto.setIngredients(IngredientDtos);
		recipeInfoResponseDto.setWriter(recipe.getMember().getNickname());
		recipeInfoResponseDto.setCreatedDate(recipe.getCreatedDate());
		recipeInfoResponseDto.setUpdateDate(recipe.getUpdatedDate());

		return recipeInfoResponseDto;
	}
}
