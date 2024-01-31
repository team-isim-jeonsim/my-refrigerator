package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.entity.RecipeIngredient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeUpdateResponseDto {

	private Long id;
	private String title;
	private String content;
	private List<IngredientResponseDto> ingredients;
	private String writer;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	public static RecipeUpdateResponseDto toDto(Recipe recipe) {
		RecipeUpdateResponseDto dto = RecipeUpdateResponseDto.builder()
			.id(recipe.getId())
			.title(recipe.getTitle())
			.content(recipe.getContent())
			.writer(recipe.getMember().getNickname())
			.createdDate(recipe.getCreatedDate())
			.updatedDate(recipe.getUpdatedDate())
			.build();

		dto.addIngredients(recipe.getRecipeIngredient());

		return dto;
	}

	private void addIngredients(List<RecipeIngredient> recipeIngredients) {
		this.ingredients = recipeIngredients.stream()
			.map(ri -> IngredientResponseDto.toDto(ri.getIngredient()))
			.collect(Collectors.toList());
	}
}
