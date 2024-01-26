package com.ll.naengcipe.domain.recipe.recipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ll.naengcipe.global.dto.ErrorResponseDto;

@RestControllerAdvice
public class RecipeControllerAdvice {

	/**
	 * 검색시 Cond는 있지만, keyword가 null 혹은 빈문자열인 경우, 예외처리
	 */
	@ExceptionHandler(KeywordIsBlankException.class)
	public ResponseEntity<ErrorResponseDto> handleKeywordIsBlankExceptions(KeywordIsBlankException ex) {
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
