package com.ll.naengcipe.domain.member.member.dto;

import java.util.Set;

import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MyFridgeResponseDto {
	private MemberResponseDto member;
	private Set<IngredientResponseDto> myIngredients;
}
