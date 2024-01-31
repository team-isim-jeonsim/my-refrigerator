package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipeInfoResponseDto {

	private Long id;
	private String title;
	private String content;
	private List<IngredientResponseDto> ingredients;
	private String writer;
	private LocalDateTime createdDate;
	private LocalDateTime updateDate;
}
