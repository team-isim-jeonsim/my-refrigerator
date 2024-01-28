package com.ll.naengcipe.domain.recipe.recipe.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeUpdateDto;
import com.ll.naengcipe.domain.recipe.recipe.service.RecipeService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {

	private final RecipeService recipeService;

	@PostMapping
	public ResponseEntity<RecipeCreateDto> registerPost(@RequestBody RecipeCreateRequestDto requestDto) {

		RecipeCreateDto createIdDto = recipeService.write(requestDto);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{Id}")
			.buildAndExpand(createIdDto.getId())
			.toUri();

		return ResponseEntity.created(location).body(createIdDto);
	}

	@PutMapping("/{recipeId}")
	public ResponseEntity<?> updateRecipe(@PathVariable Long recipeId, @RequestBody RecipeUpdateDto recipeUpdateDto) {
		recipeService.edit(recipeId, recipeUpdateDto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{recipeId}")
	public ResponseEntity<?> deleteRecipe(@PathVariable Long recipeId) {
		recipeService.delete(recipeId);

		return ResponseEntity.noContent().build();
	}
}