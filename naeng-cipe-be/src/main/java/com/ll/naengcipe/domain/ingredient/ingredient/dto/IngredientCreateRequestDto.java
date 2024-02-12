package com.ll.naengcipe.domain.ingredient.ingredient.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IngredientCreateRequestDto {
	@NotNull(message = "재료 이름이 없습니다.")
	private String name;
}
