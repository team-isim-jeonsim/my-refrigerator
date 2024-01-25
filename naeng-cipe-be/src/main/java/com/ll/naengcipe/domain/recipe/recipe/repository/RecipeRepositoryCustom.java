package com.ll.naengcipe.domain.recipe.recipe.repository;

import java.util.List;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;

public interface RecipeRepositoryCustom {
	List<RecipeResponseDto> findRecipesByIngredients(List<Long> ingredients);
}
