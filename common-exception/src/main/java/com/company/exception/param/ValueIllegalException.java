package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * <p>Title: EmptyValueException<／p>
 * <p>Description: 参数值非法异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class ValueIllegalException extends ParamException {

    public ValueIllegalException(String paramName, Object paramValue) {
        this(paramName, paramValue, null);
    }

    public ValueIllegalException(String paramName, Object paramValue, String message) {
        super("1003", "参数值非法", paramName, paramValue, message);
    }
}
