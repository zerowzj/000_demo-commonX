package com.company.exception;

/**
 * 基本异常
 *
 * @author wangzhj
 */
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode = null;
    /**
     * 错误描述
     */
    private String errorDesc = null;

    public BaseException() {
        super();
    }

    public BaseException(String errorCode, String errorDesc) {
        this(errorCode, errorDesc, null);
    }

    public BaseException(String errorCode, String errorDesc, String message) {
        super(ExceptionUtil.buildMessage(errorCode, errorDesc, message));
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
