package com.ll.naengcipe.domain.recipe.recipe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeInfoResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.exception.RecipeException;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeInfoResponseDto findRecipe(Long recipeId) {
		// 1. 레시피 아이디가 유효한 아이디인지 확인
		Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);

		if (optionalRecipe.isEmpty()) {
			// 유효하지 않은 아이디일 경우(null인 경우)
			throw new RecipeException("유효하지 않은 아이디입니다.");
		}

		Recipe recipe = optionalRecipe.get();

		// 2. 유효한 아이디일 경우 레시피 정보 조회
		RecipeInfoResponseDto recipeInfoResponseDto = new RecipeInfoResponseDto();
		recipeInfoResponseDto.setId(recipe.getId());
		recipeInfoResponseDto.setTitle(recipe.getTitle());
		recipeInfoResponseDto.setContent(recipe.getContent());
		recipeInfoResponseDto.setIngredients(recipeRepository.getIngredientNameByRecipe(recipeId));
		recipeInfoResponseDto.setWriter(recipe.getMember().getNickname());
		recipeInfoResponseDto.setCreatedDate(recipe.getCreatedDate());
		recipeInfoResponseDto.setUpdateDate(recipe.getUpdatedDate());

		return recipeInfoResponseDto;
	}
}
