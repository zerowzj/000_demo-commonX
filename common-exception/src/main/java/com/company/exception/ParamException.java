package com.company.exception;

/**
 * <p>参数异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class ParamException extends BaseException {

    public ParamException(String errorCode, String errorDesc, String message) {
        super(errorCode, errorDesc, message);
    }
}
