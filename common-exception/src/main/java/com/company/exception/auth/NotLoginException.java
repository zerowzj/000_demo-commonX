package com.company.exception.auth;

import com.company.exception.AuthException;

/**
 * 未登录异常
 *
 * @author wangzhj
 */
public class NotLoginException extends AuthException {

    public NotLoginException(){
        super("8003", "未登录");
    }
}
