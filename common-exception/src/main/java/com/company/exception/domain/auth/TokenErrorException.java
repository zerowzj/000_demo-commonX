package com.company.exception.domain.auth;

import com.company.exception.domain.AuthException;

/**
 * token错误或过期异常
 *
 * @author wangzhj
 */
public class TokenErrorException extends AuthException {

    public TokenErrorException() {
        super("", "token错误或过期");
    }
}
