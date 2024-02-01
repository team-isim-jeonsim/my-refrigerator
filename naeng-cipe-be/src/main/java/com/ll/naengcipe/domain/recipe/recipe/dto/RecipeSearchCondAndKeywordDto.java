package com.ll.naengcipe.domain.recipe.recipe.dto;

import org.springframework.util.StringUtils;

import lombok.Data;

@Data
public class RecipeSearchCondAndKeywordDto {

	private RecipeSearchCond cond;
	private String keyword;

	public boolean isKeywordBlank() {
		return !StringUtils.hasText(keyword);
	}
}
