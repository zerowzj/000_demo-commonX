package com.company.exception.auth;

import com.company.exception.AuthException;
import com.company.exception.MessageUtil;

/**
 * 未授权异常
 *
 * @author wangzhj
 */
public class NotAuthorizedException extends AuthException {

    public NotAuthorizedException(){
        super("8004", MessageUtil.format("auth.error.notAuthorized"));
    }
}
