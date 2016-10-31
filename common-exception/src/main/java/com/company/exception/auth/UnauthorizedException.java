package com.company.exception.auth;

import com.company.exception.AuthException;

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
