package com.company.exception.domain.auth;

import com.company.exception.domain.AuthException;

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
