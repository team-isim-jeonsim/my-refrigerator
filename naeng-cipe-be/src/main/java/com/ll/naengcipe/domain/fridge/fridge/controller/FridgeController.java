package com.ll.naengcipe.domain.fridge.fridge.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.fridge.fridge.dto.FridgeResponseDto;
import com.ll.naengcipe.domain.fridge.fridge.service.FridgeService;
import com.ll.naengcipe.domain.ingredient.ingredient.service.IngredientService;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchResponseDto;
import com.ll.naengcipe.global.security.authentiation.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/my-fridge")
@RequiredArgsConstructor
@Slf4j
public class FridgeController {
	private final FridgeService fridgeService;
	private final IngredientService ingredientService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/ingredients/{ingredientId}")
	public ResponseEntity<FridgeResponseDto> addIngredient(@PathVariable("ingredientId") Long id,
		@AuthenticationPrincipal UserPrincipal user) {
		return ResponseEntity.ok(fridgeService.addIngredient(id, user.getMember().getId()));
	}

	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/ingredients/{ingredientId}") // 데이터베이스에 있는 재료 삭제
	public void removeIngredient(@PathVariable("ingredientId") Long id,
		@AuthenticationPrincipal UserPrincipal user) {

		fridgeService.removeIngredient(id, user.getMember().getId());
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/recipes")
	public ResponseEntity<List<RecipeSearchResponseDto>> fridgeRecipeList(
		@RequestParam("ingredient") List<Long> ingredients) {

		return ResponseEntity.ok(fridgeService.findRecipesContainIngredients(ingredients));
	}
}
