package com.ll.naengcipe.global.security.jwt.dto;

import com.ll.naengcipe.domain.member.member.dto.MemberResponseDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
public class JwtResponse {
	private final String accessToken;
	private final Long accessTokenExp;
	private final String refreshToken;
	private MemberResponseDto member;
}
