package com.company.exception.auth;

import com.company.exception.AuthException;

import static com.company.exception.MessageUtil.format;

/**
 * token过期或错误异常
 *
 * @author wangzhj
 */
public class TokenExpireOrErrorException extends AuthException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "auth.error.tokenExpireOrError";

    public TokenExpireOrErrorException() {
        super(ERROR_CODE, format(DESC_KEY));
    }
}
