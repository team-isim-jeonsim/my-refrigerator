package com.ll.naengcipe.global.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ll.naengcipe.global.dto.ErrorResponseDto;

/**
 * @author 장다슬
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
	/**
	 * '@Valid' 유효성 검증 예외 처리
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> validErrors = new HashMap<>();

		ex.getBindingResult().getAllErrors()
			.forEach(c -> validErrors.put(((FieldError)c).getField(), c.getDefaultMessage()));

		ErrorResponseDto error = ErrorResponseDto.builder()
			.status(ex.getStatusCode().value())
			.message(ex.getMessage())
			.valid(validErrors)
			.build();

		return ResponseEntity.badRequest().body(error);
	}

	/**
	 * 접근 권한이 없을 경우 예외 처리
	 */
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponseDto> handleRequestNotReadableExceptions(AccessDeniedException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
			.body(common(HttpStatus.FORBIDDEN.value(), ex.getMessage(), ex.getClass().getName()));
	}

	public ErrorResponseDto common(int status, String message, String type) {
		return ErrorResponseDto.builder()
			.status(status)
			.message(message)
			.type(type)
			.build();
	}
}
