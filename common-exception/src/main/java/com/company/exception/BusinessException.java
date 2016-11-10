package com.company.exception;

/**
 * <p>业务异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class BusinessException extends BaseException {

    public BusinessException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc, errorDesc);
    }

    public BusinessException(String errorCode, String errorDesc, String message) {
        super(errorCode, errorDesc, message);
    }
}
