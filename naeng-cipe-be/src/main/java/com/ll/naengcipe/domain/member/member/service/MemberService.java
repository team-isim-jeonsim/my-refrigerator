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

import com.ll.naengcipe.domain.member.member.dto.MemberModifyRequestDto;
import com.ll.naengcipe.domain.member.member.dto.MemberModifyResponseDto;
import com.ll.naengcipe.global.security.authentiation.UserPrincipal;

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

	@Transactional
	public MemberModifyResponseDto modifyMember(UserPrincipal user, MemberModifyRequestDto memberModifyRequestDto) {
		Member member = memberRepository.findById(user.getMember().getId())
			.orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

		if (!memberModifyRequestDto.getPassword().equals(memberModifyRequestDto.getPasswordCheck())) {
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}

		member.update(memberModifyRequestDto.getPassword(), memberModifyRequestDto.getNickname());

		MemberModifyResponseDto responseDto = MemberModifyResponseDto.builder()
			.id(member.getId())
			.email(member.getEmail())
			.password(member.getPassword())
			.nickname(member.getNickname())
			.updatedDate(member.getUpdatedDate())
			.build();

		return responseDto;
	}
}
