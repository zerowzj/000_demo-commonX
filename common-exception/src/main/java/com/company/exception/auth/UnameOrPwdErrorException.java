package com.company.exception.auth;

import com.company.exception.AuthException;

import static com.company.exception.MessageUtil.format;

/**
 * 用户名或密码错误异常
 *
 * @author wangzhj
 */
public class UnameOrPwdErrorException extends AuthException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "auth.error.unameOrPwdError";

    public UnameOrPwdErrorException() {
        super(ERROR_CODE, format(DESC_KEY));
    }
}
