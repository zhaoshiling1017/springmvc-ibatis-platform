package com.ducetech.api.security;

/**
 * 令牌异常
 */
public class TokenException extends RuntimeException {

    public TokenException(String message) {
        super(message);
    }
}
