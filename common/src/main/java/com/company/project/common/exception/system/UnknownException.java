package com.company.project.common.exception.system;

/**
 * 未知异常
 *
 * @author wangzhj
 */
public class UnknownException extends SystemException {

    public UnknownException(String errorDesc, Throwable cause){
        super(errorDesc, cause);
    }
}
