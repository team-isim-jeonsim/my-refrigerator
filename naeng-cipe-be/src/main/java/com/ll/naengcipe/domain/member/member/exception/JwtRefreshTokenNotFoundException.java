package com.ll.naengcipe.domain.member.member.exception;

public class JwtRefreshTokenNotFoundException extends RuntimeException {
    public JwtRefreshTokenNotFoundException(String message) {
        super(message);
    }
}
