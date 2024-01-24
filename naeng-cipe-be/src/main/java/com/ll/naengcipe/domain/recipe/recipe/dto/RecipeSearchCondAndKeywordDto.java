package com.ll.naengcipe.domain.recipe.recipe.dto;

import lombok.Data;

@Data
public class RecipeSearchCondAndKeywordDto {
	private RecipeSearchCond cond;
	private String keyword;
}
