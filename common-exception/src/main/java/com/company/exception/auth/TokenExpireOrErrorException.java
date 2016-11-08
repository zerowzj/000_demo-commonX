package com.company.exception.auth;

import com.company.exception.AuthException;
import com.company.exception.MessageUtil;

/**
 * token过期或错误异常
 *
 * @author wangzhj
 */
public class TokenExpireOrErrorException extends AuthException {

    public TokenExpireOrErrorException() {
        super("8003", MessageUtil.format("auth.error.tokenExpireOrError"));
    }
}
