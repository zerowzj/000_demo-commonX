package com.company.exception.system;

import com.company.exception.SystemException;

/**
 * <p>未知异常</p>
 *
 * @author wangzhj
 * @time 2016-11-24 17:25
 */
public class UnknownException extends SystemException {

    public UnknownException(Throwable cause){
        super("", "", cause);
    }
}
