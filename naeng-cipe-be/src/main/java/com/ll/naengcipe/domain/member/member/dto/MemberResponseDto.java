package com.ll.naengcipe.domain.member.member.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class MemberResponseDto {
	private Long id;
	private String email;
	private String nickname;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	public static MemberResponseDto of(MemberDto memberDto) {
		return MemberResponseDto.builder()
			.id(memberDto.getId())
			.email(memberDto.getEmail())
			.nickname(memberDto.getNickname())
			.createdDate(memberDto.getCreatedDate())
			.updatedDate(memberDto.getUpdatedDate())
			.build();
	}
}
