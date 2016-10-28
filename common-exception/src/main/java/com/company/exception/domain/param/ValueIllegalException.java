package com.company.exception.domain.param;

import com.company.exception.domain.ParamException;

/**
 * 参数值非法异常
 *
 * @author wangzhj
 */
public class ValueIllegalException extends ParamException {

    public ValueIllegalException(String paramName, String paramValue) {
        super("1003", "参数值非法", paramName, paramValue);
    }
}
