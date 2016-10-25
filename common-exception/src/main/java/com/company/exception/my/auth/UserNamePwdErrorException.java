package com.company.exception.my.auth;

import com.company.exception.base.AuthException;

/**
 * 用户名或密码错误异常
 *
 * @author wangzhj
 */
public class UserNamePwdErrorException extends AuthException {

    public UserNamePwdErrorException() {
        super("", "用户名或密码错误");
    }
}
