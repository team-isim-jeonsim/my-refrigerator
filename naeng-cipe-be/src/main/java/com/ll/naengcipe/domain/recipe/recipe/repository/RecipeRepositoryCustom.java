package com.ll.naengcipe.domain.recipe.recipe.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;

public interface RecipeRepositoryCustom {
	List<RecipeResponseDto> findRecipesByIngredients(List<Long> ingredients);

	Page<RecipeResponseDto> findAllThroughSearch(Pageable pageable, RecipeSearchCondAndKeywordDto recipeSearchCond);
}
