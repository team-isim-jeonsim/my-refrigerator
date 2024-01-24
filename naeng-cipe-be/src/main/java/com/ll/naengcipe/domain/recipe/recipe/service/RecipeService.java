package com.ll.naengcipe.domain.recipe.recipe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public Page<Recipe> findRecipeList(Pageable pageable, RecipeSearchCondAndKeywordDto recipeSearchDto) {
		return recipeRepository.findAllWithMember(pageable);
	}
}
