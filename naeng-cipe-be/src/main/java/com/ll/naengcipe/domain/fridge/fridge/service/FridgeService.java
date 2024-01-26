package com.ll.naengcipe.domain.fridge.fridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FridgeService {

	private final RecipeRepository recipeRepository;

	public List<RecipeSearchResponseDto> findRecipesContainIngredients(List<Long> ingredients) {

		return recipeRepository.findRecipesByIngredients(ingredients);
	}
}
