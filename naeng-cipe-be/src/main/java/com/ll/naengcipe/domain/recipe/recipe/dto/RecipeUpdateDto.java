package com.ll.naengcipe.domain.recipe.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeUpdateDto {
	private String title;
	private String content;
	private String ingredients;
	private String cookingOrder;
}
