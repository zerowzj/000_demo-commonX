package com.company.exception;

/**
 * 基本异常
 *
 * @author wangzhj
 */
public class BaseException extends RuntimeException {

    /** 错误码 */
    private String errorCode = null;
    /** 错误描述 */
    private String errorDesc = null;

    public BaseException() {
        super();
    }

    public BaseException(String errorCode, String errorDesc, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
