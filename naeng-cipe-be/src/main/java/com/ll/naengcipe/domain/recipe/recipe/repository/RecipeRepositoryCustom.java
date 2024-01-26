package com.ll.naengcipe.domain.recipe.recipe.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;

public interface RecipeRepositoryCustom {
	List<RecipeSearchResponseDto> findRecipesByIngredients(List<Long> ingredients);

	Page<RecipeSearchResponseDto> findAllThroughSearch(Pageable pageable, RecipeSearchCondAndKeywordDto recipeSearchCond);
}
