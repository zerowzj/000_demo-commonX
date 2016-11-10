package com.company.exception.auth;

import com.company.exception.AuthException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>未授权异常</p>
 *
 * @author wangzhj
 */
public class NotAuthorizedException extends AuthException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "auth.error.notAuthorized";

    public NotAuthorizedException() {
        super(ERROR_CODE, format(DESC_KEY));
    }
}
