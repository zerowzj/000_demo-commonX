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
    /**
     * 错误详情
     */
    private String errorDetail = null;

    public BaseException() {
        super();
    }

    public BaseException(String errorCode, String errorDesc) {

        this(errorCode, errorDesc, null);
    }

    public BaseException(String errorCode, String errorDesc, String errorDetail) {
        super(errorDesc + "[" + errorCode + "]");
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.errorDetail = errorDetail;
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

    public String getErrorDetail() {
        return errorDetail;
    }
}
