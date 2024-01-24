package com.ll.naengcipe.domain.member.member.service;

import com.ll.naengcipe.domain.member.member.dto.JoinRequestDto;
import com.ll.naengcipe.domain.member.member.dto.MemberDto;
import com.ll.naengcipe.domain.member.member.dto.MemberResponseDto;
import com.ll.naengcipe.domain.member.member.entity.Member;
import com.ll.naengcipe.domain.member.member.exception.PasswordNotMatchException;
import com.ll.naengcipe.domain.member.member.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResponseDto addMember(@Valid JoinRequestDto joinDto) {
        MemberDto memberDto = MemberDto.builder()
                .email(joinDto.getEmail())
                .password(joinDto.getPassword())
                .nickname(joinDto.getNickname())
                .build();

        MemberDto encodingMember = memberDto.toBuilder().password(passwordEncoder.encode(memberDto.getPassword())).build();
        Member memberEntity = memberRepository.save(MemberDto.toEntity(encodingMember));

        return new MemberResponseDto(new MemberDto(memberEntity));
    }
}
