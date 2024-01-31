package com.ll.naengcipe.domain.member.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberModifyRequestDto {
	private String password;
	private String passwordCheck;
	private String nickname;
}
