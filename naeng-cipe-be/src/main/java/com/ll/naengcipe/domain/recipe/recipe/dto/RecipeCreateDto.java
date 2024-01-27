package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeCreateDto {

	private Long id;
	private String title;
	private String content;
	private String ingredients;
	private String cookingOrder;
	private String writer;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
