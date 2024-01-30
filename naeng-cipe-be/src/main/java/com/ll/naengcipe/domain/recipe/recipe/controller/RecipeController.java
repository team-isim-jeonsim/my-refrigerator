package com.ll.naengcipe.domain.recipe.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.service.RecipeService;
import com.ll.naengcipe.global.security.authentiation.UserPrincipal;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {

	private final RecipeService recipeService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping
	public ResponseEntity<?> recipeAdd(
		@AuthenticationPrincipal UserPrincipal user,
		@RequestBody RecipeCreateRequestDto recipeCreateDto) {

		RecipeCreateResponseDto recipeResponseDto = recipeService.addRecipe(user.getMember(), recipeCreateDto);
		return
			ResponseEntity.status(HttpStatus.CREATED).body(recipeResponseDto);
	}
}
