package com.ll.naengcipe.domain.ingredient.ingredient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IngredientNotUniqueException extends RuntimeException {
	public IngredientNotUniqueException(String message) {
		super(message);
	}
}
