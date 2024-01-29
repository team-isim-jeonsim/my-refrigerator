package com.ll.naengcipe.domain.recipe.recipe.exception;

public class RecipeException extends RuntimeException {
	public RecipeException(String message) {
		super(message);
	}

	public RecipeException(String message, Throwable cause) {
		super(message, cause);
	}
}
