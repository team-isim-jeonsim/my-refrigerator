package com.ll.naengcipe.domain.ingredient.ingredient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ll.naengcipe.global.dto.ErrorResponseDto;

@RestControllerAdvice
public class IngredientControllerAdvice {

	@ExceptionHandler(IngredientNotExistException.class)
	public ResponseEntity<ErrorResponseDto> handleIngredientNotExistException(IngredientNotExistException ex) {
		return ResponseEntity.badRequest()
			.body(
				createErrorResponseDto(
					HttpStatus.BAD_REQUEST.value(),
					ex.getMessage(),
					ex.getClass().getName()
				)
			);
	}

	@ExceptionHandler(IngredientNotUniqueException.class)
	public ResponseEntity<ErrorResponseDto> handleIngredientNotUniqueException(IngredientNotUniqueException ex) {
		return ResponseEntity.badRequest()
			.body(
				createErrorResponseDto(
					HttpStatus.BAD_REQUEST.value(),
					ex.getMessage(),
					ex.getClass().getName()
				)
			);
	}

	public ErrorResponseDto createErrorResponseDto(int status, String message, String type) {
		return ErrorResponseDto.builder()
			.status(status)
			.message(message)
			.type(type)
			.build();
	}

}
