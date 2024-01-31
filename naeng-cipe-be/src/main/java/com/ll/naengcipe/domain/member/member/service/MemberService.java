package com.ll.naengcipe.domain.member.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.member.member.dto.MemberModifyRequestDto;
import com.ll.naengcipe.domain.member.member.dto.MemberModifyResponseDto;
import com.ll.naengcipe.domain.member.member.entity.Member;
import com.ll.naengcipe.domain.member.member.repository.MemberRepository;
import com.ll.naengcipe.global.security.authentiation.UserPrincipal;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

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
