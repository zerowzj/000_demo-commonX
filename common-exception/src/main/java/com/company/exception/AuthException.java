package com.company.exception;

/**
 * 认证/授权异常
 *
 * @author wangzhj
 */
public class AuthException extends BaseException {

    public AuthException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc, errorDesc);
    }
}
