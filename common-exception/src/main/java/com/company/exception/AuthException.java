package com.company.exception;

/**
 * <p>认证/授权异常</p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class AuthException extends BaseException {

    /**
     * 构造认证/授权异常
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     */
    public AuthException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc, errorDesc);
    }
}
