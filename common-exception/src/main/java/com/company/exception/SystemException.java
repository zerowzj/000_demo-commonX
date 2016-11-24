package com.company.exception;

/**
 * <p>系统异常</p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class SystemException extends BaseException {

    /**
     * 构造系统异常
     *
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     */
    public SystemException(String errorCode, String errorDesc, Throwable cause) {
        super(errorCode, errorDesc, errorDesc);
    }
}
