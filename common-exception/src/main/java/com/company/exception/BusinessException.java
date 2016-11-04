package com.company.exception;

/**
 * <p>Title: BusinessException<／p>
 * <p>Description: 业务异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class BusinessException extends BaseException {

    public BusinessException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc, errorDesc);
    }
}
