package com.ll.naengcipe.domain.member.member.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class MemberModifyResponseDto {
	private Long id;
	private String email;
	private String password;
	private String nickname;
	private LocalDateTime updatedDate;

	public MemberModifyResponseDto(MemberDto dto) {
		this.id = dto.getId();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.nickname = dto.getNickname();
		this.updatedDate = dto.getUpdatedDate();
	}
}
