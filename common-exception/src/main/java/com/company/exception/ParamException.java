package com.company.exception;

/**
 * <p>参数异常</p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class ParamException extends BaseException {

    /**
     * 构造参数异常
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     */
    public ParamException(String errorCode, String errorDesc) {
        this(errorCode, errorDesc, errorDesc);
    }

    /**
     * 构造带有详细信息的参数异常
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     * @param message   异常信息
     */
    public ParamException(String errorCode, String errorDesc, String message) {
        super(errorCode, errorDesc, message);
    }
}
