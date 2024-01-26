package com.ll.naengcipe.domain.recipe.recipe.service;

import org.springframework.stereotype.Service;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeCreateDto write(RecipeRequestDto requestDto) {
		Recipe recipe = Recipe.builder()
		    .title(requestDto.getTitle())
			.content(requestDto.getContent())
			.ingredients(requestDto.getIngredients())
			.cookingOrder(requestDto.getCookingOrder())
			.build();

		Recipe savedRecipe = recipeRepository.save(recipe);

		return RecipeCreateDto.builder()
			.Id(savedRecipe.getId())
			.title(savedRecipe.getTitle())
			.content(savedRecipe.getContent())
			.ingredients(savedRecipe.getIngredients())
			.cookingOrder(savedRecipe.getCookingOrder())
			.writer(savedRecipe.getWriter())
			.createdDate(savedRecipe.getCreatedDate())
			.updatedDate(savedRecipe.getUpdatedDate())
			.build();
	}

}
