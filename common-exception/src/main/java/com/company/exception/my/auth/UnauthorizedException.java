package com.company.exception.my.auth;

import com.company.exception.base.AuthException;

/**
 * 未授权异常
 *
 * @author wangzhj
 */
public class UnauthorizedException extends AuthException {

    public UnauthorizedException(){
        super("", "未被授权");
    }
}
