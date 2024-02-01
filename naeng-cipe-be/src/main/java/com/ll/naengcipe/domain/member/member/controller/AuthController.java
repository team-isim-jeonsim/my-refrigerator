package com.ll.naengcipe.domain.member.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.member.member.dto.JoinRequestDto;
import com.ll.naengcipe.domain.member.member.dto.LoginRequestDto;
import com.ll.naengcipe.domain.member.member.dto.MemberResponseDto;
import com.ll.naengcipe.domain.member.member.exception.PasswordNotMatchException;
import com.ll.naengcipe.domain.member.member.service.AuthService;
import com.ll.naengcipe.global.security.jwt.dto.JwtResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;

	/**
	 * 로그인
	 */
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> memberLogin(@Valid @RequestBody LoginRequestDto loginDto) {
		return ResponseEntity.ok(
			authService.loginMember(loginDto)
		);
	}

	/**
	 * 액세스 토큰 재발급
	 */
	@PostMapping("/token/reissue")
	public ResponseEntity<?> reissueAccessToken(@RequestBody String refreshToken) {
		log.info("refreshToken controller : {}", refreshToken);
		return ResponseEntity.ok(authService.newAccessToken(refreshToken));
	}

	/**
	 * 회원가입
	 */
	@PostMapping("/join")
	public ResponseEntity<MemberResponseDto> memberAdd(@Valid @RequestBody JoinRequestDto joinDto) {
		if (!joinDto.isPasswordCheck()) {
			throw new PasswordNotMatchException("비밀번호가 일치하지 않습니다.");
		}

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(authService.addMember(joinDto));
	}
}
