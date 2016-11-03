package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * 参数值非法异常
 *
 * @author wangzhj
 */
public class ValueIllegalException extends ParamException {

    public ValueIllegalException(String paramName, Object paramValue) {
        this(paramName, paramValue, null);
    }

    public ValueIllegalException(String paramName, Object paramValue, String message) {
        super("1003", "参数值非法", paramName, paramValue, message);
    }
}
