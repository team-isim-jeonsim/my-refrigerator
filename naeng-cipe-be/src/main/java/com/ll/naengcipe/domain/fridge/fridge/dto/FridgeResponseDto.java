package com.ll.naengcipe.domain.fridge.fridge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FridgeResponseDto {
	private Long memberId;
	private Long ingredientId;
	private String name;

	public FridgeResponseDto(Long ingredientId, String name) {
		this.ingredientId = ingredientId;
		this.name = name;
	}
}
