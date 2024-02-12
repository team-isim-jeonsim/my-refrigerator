package com.ll.naengcipe.domain.ingredient.ingredient.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientCreateRequestDto;
import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;
import com.ll.naengcipe.domain.ingredient.ingredient.service.IngredientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor
public class IngredientController {

	private final IngredientService ingredientService;

	@PreAuthorize("isAuthenticated()")
	@GetMapping
	public ResponseEntity<List<IngredientResponseDto>> ingredientList() {
		List<IngredientResponseDto> ingredientDtos = ingredientService.findIngredient()
			.stream()
			.map(ingredient -> new IngredientResponseDto(ingredient.getId(), ingredient.getName()))
			.toList();
		return ResponseEntity.ok(ingredientDtos);
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping
	public ResponseEntity<IngredientResponseDto> ingredientAdd(
		@Valid @RequestBody IngredientCreateRequestDto ingredientDto) {
		IngredientResponseDto ingredientResponseDto = ingredientService.addIngredient(ingredientDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(ingredientResponseDto);
	}
}
