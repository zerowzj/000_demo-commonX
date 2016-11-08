package com.company.exception;

/**
 * <p>系统异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public abstract class SystemException extends BaseException {

    public SystemException(){

    }

    public SystemException(Throwable cause) {
        super("", "", cause);
    }
}
