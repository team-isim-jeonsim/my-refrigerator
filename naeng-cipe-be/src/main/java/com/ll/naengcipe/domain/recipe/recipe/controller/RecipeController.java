package com.ll.naengcipe.domain.recipe.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeInfoResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeUpdateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeUpdateResponseDto;
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

	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{recipeId}")
	public ResponseEntity<?> recipeModify(@AuthenticationPrincipal UserPrincipal user,
		@RequestBody RecipeUpdateRequestDto recipeUpdateDto) {

		RecipeUpdateResponseDto updateResponseDto = recipeService.modifyRecipe(user.getMember(), recipeUpdateDto);

		return ResponseEntity.ok(updateResponseDto);
	}

	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{recipeId}")
	public ResponseEntity<?> recipeRemove(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long recipeId) {

		recipeService.removeRecipe(user.getMember(), recipeId);

		return ResponseEntity.ok(null);
	}

	@GetMapping("/api/recipes/{recipeId}")
	public ResponseEntity<RecipeInfoResponseDto> recipeDetails(@PathVariable Long recipeId) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.findRecipe(recipeId));
	}
}
