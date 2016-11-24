package com.company.exception.auth;

import com.company.exception.AuthException;

import static com.company.exception.util.MessageUtil.format;

/**
 * <p>token过期或错误异常</p>
 *
 * @author wangzhj
 */
public class TokenExpiredOrErrorException extends AuthException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "auth.error.tokenExpireOrError";

    public TokenExpiredOrErrorException() {
        super(ERROR_CODE, format(DESC_KEY));
    }
}
