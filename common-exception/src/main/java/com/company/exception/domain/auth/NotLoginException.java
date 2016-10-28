package com.company.exception.domain.auth;

import com.company.exception.domain.AuthException;

/**
 * 未登录异常
 *
 * @author wangzhj
 */
public class NotLoginException extends AuthException {

    public NotLoginException(){
        super("", "未登录");
    }
}
