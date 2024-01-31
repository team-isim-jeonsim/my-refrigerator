package com.ll.naengcipe.domain.member.member.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.fridge.fridge.entity.Fridge;
import com.ll.naengcipe.domain.fridge.fridge.entity.FridgeIngredient;
import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientDto;
import com.ll.naengcipe.domain.member.member.dto.MemberDto;
import com.ll.naengcipe.domain.member.member.dto.MemberResponseDto;
import com.ll.naengcipe.domain.member.member.dto.MyFridgeResponseDto;
import com.ll.naengcipe.domain.member.member.entity.Member;
import com.ll.naengcipe.domain.member.member.exception.UserNotFoundException;
import com.ll.naengcipe.domain.member.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberResponseDto findMember(final String email) {
		Member memberEntity = memberRepository.findByEmail(email)
			.orElseThrow(() -> new UserNotFoundException("존재하지 않는 회원입니다."));
		return MemberResponseDto.of(new MemberDto(memberEntity));
	}

	public MyFridgeResponseDto findMyFridge(final Fridge fridge) {
		Set<IngredientDto> ingredientDtos = new HashSet<>();

		for (FridgeIngredient fridgeIngredient : fridge.getFridgeIngredients()) {
			ingredientDtos.add(new IngredientDto(fridgeIngredient.getIngredient()));
		}

		return MyFridgeResponseDto.builder()
			.member(MemberResponseDto.of(new MemberDto(fridge.getMember())))
			.myIngredients(ingredientDtos)
			.build();
	}
}
