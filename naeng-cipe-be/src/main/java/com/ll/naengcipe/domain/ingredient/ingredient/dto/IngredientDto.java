package com.ll.naengcipe.domain.ingredient.ingredient.dto;

import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDto {
	private Long id;
	private String name;

	public IngredientDto(Ingredient ingredient) {
		this.id = ingredient.getId();
		this.name = ingredient.getName();
	}
}
