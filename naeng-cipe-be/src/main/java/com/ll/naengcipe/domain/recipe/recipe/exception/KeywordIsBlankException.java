package com.ll.naengcipe.domain.recipe.recipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class KeywordIsBlankException extends RuntimeException {
	public KeywordIsBlankException(String msg) {
		super(msg);
	}
}
