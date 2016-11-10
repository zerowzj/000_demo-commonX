package com.company.exception.auth;

import com.company.exception.AuthException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>未登录异常</p>
 *
 * @author wangzhj
 */
public class NotLoginException extends AuthException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "auth.error.notLogin";

    public NotLoginException() {
        super(ERROR_CODE, format(DESC_KEY));
    }
}
