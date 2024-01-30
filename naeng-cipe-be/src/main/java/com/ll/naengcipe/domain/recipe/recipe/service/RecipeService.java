package com.ll.naengcipe.domain.recipe.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;
import com.ll.naengcipe.domain.ingredient.ingredient.exception.IngredientNotExistException;
import com.ll.naengcipe.domain.ingredient.ingredient.repository.IngredientRepository;
import com.ll.naengcipe.domain.member.member.entity.Member;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.entity.RecipeIngredient;
import com.ll.naengcipe.domain.recipe.recipe.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final IngredientRepository ingredientRepository;

	@Transactional
	public RecipeCreateResponseDto addRecipe(Member member, RecipeCreateRequestDto recipeCreateDto) {

		List<Ingredient> ingredients = ingredientRepository.findByIdIn(recipeCreateDto.getIngredients());
		if (ingredientNotExist(recipeCreateDto.getIngredients().size(), ingredients.size())) {
			throw new IngredientNotExistException("해당 재료가 존재하지 않습니다.");
		}

		List<RecipeIngredient> recipeIngredients = new ArrayList<>();
		for (Ingredient ingredient : ingredients) {
			recipeIngredients.add(new RecipeIngredient(ingredient));
		}

		Recipe recipe = Recipe.createRecipe(member, recipeCreateDto.getTitle(), recipeCreateDto.getContent(),
			recipeIngredients);
		Recipe savedRecipe = recipeRepository.save(recipe);

		return RecipeCreateResponseDto.toDto(savedRecipe);
	}

	private boolean
	ingredientNotExist(int requestIngredientSize, int size) {

		return size != requestIngredientSize;
	}
}
