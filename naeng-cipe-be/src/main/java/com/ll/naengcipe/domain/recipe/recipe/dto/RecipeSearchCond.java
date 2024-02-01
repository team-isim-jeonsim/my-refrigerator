package com.ll.naengcipe.domain.recipe.recipe.dto;

import lombok.Getter;

@Getter
public enum RecipeSearchCond {
	TITLE("title"), BODY("body"), TNB("tnb");

	private final String value;

	RecipeSearchCond(String value) {
		this.value = value;
	}

	public static boolean isCorrectSearchCond(String value) {
		for (RecipeSearchCond type : RecipeSearchCond.values()) {
			if (type.value.equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}
}
