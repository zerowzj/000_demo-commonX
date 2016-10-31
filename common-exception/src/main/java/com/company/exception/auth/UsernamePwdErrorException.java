package com.company.exception.auth;

import com.company.exception.AuthException;

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
