package com.ll.naengcipe.domain.member.member.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.member.member.dto.MemberDto;
import com.ll.naengcipe.domain.member.member.dto.MemberModifyRequestDto;
import com.ll.naengcipe.domain.member.member.dto.MemberModifyResponseDto;
import com.ll.naengcipe.domain.member.member.entity.Member;
import com.ll.naengcipe.domain.member.member.service.MemberService;
import com.ll.naengcipe.global.security.authentiation.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	private final MemberService memberService;

	@GetMapping("/{memberId}")
	public MemberDto memberDetails(@AuthenticationPrincipal UserPrincipal user) {
		Member member = user.getMember();
		return new MemberDto(member);
	}

	@PatchMapping("/{memberId}")
	public MemberModifyResponseDto memberModify(@AuthenticationPrincipal UserPrincipal user,
		@RequestBody MemberModifyRequestDto memberModifyRequestDto) {
		return memberService.modifyMember(user, memberModifyRequestDto);
	}
}
