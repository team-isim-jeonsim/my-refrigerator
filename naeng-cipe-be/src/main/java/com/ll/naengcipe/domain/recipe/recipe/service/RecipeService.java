package com.ll.naengcipe.domain.recipe.recipe.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeUpdateDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeCreateDto write(RecipeCreateRequestDto requestDto) {
		Recipe recipe = Recipe.builder()
			.title(requestDto.getTitle())
			.content(requestDto.getContent())
			.ingredients(requestDto.getIngredients())
			.cookingOrder(requestDto.getCookingOrder())
			.build();

		Recipe savedRecipe = recipeRepository.save(recipe);

		return RecipeCreateDto.builder()
			.id(savedRecipe.getId())
			.title(savedRecipe.getTitle())
			.content(savedRecipe.getContent())
			.ingredients(savedRecipe.getIngredients())
			.cookingOrder(savedRecipe.getCookingOrder())
			.writer(savedRecipe.getWriter())
			.createdDate(savedRecipe.getCreatedDate())
			.updatedDate(savedRecipe.getUpdatedDate())
			.build();
	}

	@Transactional
	public void edit(Long id, RecipeUpdateDto recipeUpdateDto) {
		Recipe recipe = recipeRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));

		recipe.update(recipeUpdateDto);
	}

	public void delete(Long id) {
		Recipe recipe = recipeRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));

		recipeRepository.delete(recipe);
	}
}
