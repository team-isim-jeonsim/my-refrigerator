package com.ll.naengcipe.domain.ingredient.ingredient.dto;

import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientResponseDto {
	private Long id;
	private String name;

	public static IngredientResponseDto toDto(Ingredient ingredient) {
		return new IngredientResponseDto(ingredient.getId(), ingredient.getName());
	}
}
