package com.company.exception.domain.auth;

import com.company.exception.domain.AuthException;

/**
 * 用户名或密码错误异常
 *
 * @author wangzhj
 */
public class UsernamePwdErrorException extends AuthException {

    public UsernamePwdErrorException() {
        super("", "用户名或密码错误");
    }
}
