package com.example.hibernatecrud_spring.security.exep;

import org.springframework.security.core.AuthenticationException;

public class JwtAuThException extends AuthenticationException {
    public JwtAuThException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuThException(String msg) {
        super(msg);
    }
}
