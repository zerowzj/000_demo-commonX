package com.company.exception.auth;

import com.company.exception.AuthException;
import com.company.exception.MessageUtil;

/**
 * 用户名或密码错误异常
 *
 * @author wangzhj
 */
public class UnameOrPwdErrorException extends AuthException {

    public UnameOrPwdErrorException() {
        super("8002", MessageUtil.format("auth.error.unameOrPwdError"));
    }
}
