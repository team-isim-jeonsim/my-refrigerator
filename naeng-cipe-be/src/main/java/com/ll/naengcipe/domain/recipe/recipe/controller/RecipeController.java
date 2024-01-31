package com.ll.naengcipe.domain.recipe.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeInfoResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.service.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeController {
	private final RecipeService recipeService;

	@GetMapping("/api/recipes/{recipeId}")
	public ResponseEntity<RecipeInfoResponseDto> recipeDetails(@PathVariable Long recipeId) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.findRecipe(recipeId));
	}
}
