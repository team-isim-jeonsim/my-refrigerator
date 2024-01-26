package com.ll.naengcipe.domain.recipe.recipe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public Page<RecipeResponseDto> findRecipeList(Pageable pageable, RecipeSearchCondAndKeywordDto recipeSearchDto) {
		return recipeRepository.findAllThroughSearch(pageable, recipeSearchDto);
	}
}
