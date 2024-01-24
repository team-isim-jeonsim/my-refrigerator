package com.ll.naengcipe.domain.fridge.fridge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.fridge.fridge.service.FridgeService;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/my-fridge")
@RequiredArgsConstructor
public class FridgeController {

	private final FridgeService fridgeService;

	@GetMapping("/recipes")
	public List<RecipeResponseDto> fridgeRecipeList(@RequestParam("ingredient") List<Long> ingredients) {

		//Todo: 해당 재료가 없는 경우, 예외 처리

		return fridgeService.findRecipesContainIngredients(ingredients);
	}
}
