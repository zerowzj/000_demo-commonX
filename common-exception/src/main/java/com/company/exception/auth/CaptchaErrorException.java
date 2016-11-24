package com.company.exception.auth;

import com.company.exception.AuthException;

import static com.company.exception.util.MessageUtil.format;

/**
 * <p>验证码错误异常</p>
 *
 * @author wangzhj
 * @time 2016-11-10 11:48
 */
public class CaptchaErrorException extends AuthException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "auth.error.captchaError";

    public CaptchaErrorException() {
        super(ERROR_CODE, format(DESC_KEY));
    }
}
