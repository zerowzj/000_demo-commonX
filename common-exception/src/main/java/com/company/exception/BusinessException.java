package com.company.exception;

/**
 * <p>业务异常</p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class BusinessException extends BaseException {

    /**
     * 构造业务异常
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     */
    public BusinessException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc, errorDesc);
    }

    /**
     * 构造带有详细信息的业务异常
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     * @param message   异常信息
     */
    public BusinessException(String errorCode, String errorDesc, String message) {
        super(errorCode, errorDesc, message);
    }
}
