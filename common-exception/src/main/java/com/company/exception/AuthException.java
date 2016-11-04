package com.company.exception;

/**
 * <p>Title: AuthException<／p>
 * <p>Description: 认证/授权异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class AuthException extends BaseException {

    public AuthException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc, errorDesc);
    }
}
