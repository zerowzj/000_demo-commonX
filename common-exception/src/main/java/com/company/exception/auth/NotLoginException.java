package com.company.exception.auth;

import com.company.exception.AuthException;
import com.company.exception.MessageUtil;

/**
 * 未登录异常
 *
 * @author wangzhj
 */
public class NotLoginException extends AuthException {

    public NotLoginException(){
        super("8003", MessageUtil.format("auth.error.notLogin"));
    }
}
