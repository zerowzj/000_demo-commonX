package com.company.exception.auth;

import com.company.exception.AuthException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>用户不存在异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-10 11:52
 */
public class NoUnameException extends AuthException{

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "auth.error.notUname";

    public NoUnameException() {
        super(ERROR_CODE, format(DESC_KEY));
    }
}
