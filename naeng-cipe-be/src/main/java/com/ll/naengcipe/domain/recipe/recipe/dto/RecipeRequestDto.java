package com.ll.naengcipe.domain.recipe.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RecipeRequestDto {

	private String title = "";
	private String content = "";
	private String ingredients = "";
	private String cookingOrder = "";
}
