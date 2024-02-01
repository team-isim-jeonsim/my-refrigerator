package com.ll.naengcipe.domain.recipe.recipe.dto;

import org.springframework.util.StringUtils;

import com.ll.naengcipe.domain.recipe.recipe.annotation.CondEnum;

import lombok.Data;

@Data
public class RecipeSearchCondAndKeywordDto {

	@CondEnum
	private String cond;
	private String keyword;

	public boolean isKeywordBlank() {
		return !StringUtils.hasText(keyword);
	}
}
