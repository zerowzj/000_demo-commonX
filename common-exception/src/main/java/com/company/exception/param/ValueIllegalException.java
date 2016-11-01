package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * 参数值非法异常
 *
 * @author wangzhj
 */
public class ValueIllegalException extends ParamException {

    public ValueIllegalException(String paramName, Object paramValue, String errorDetail) {
        super("1003", "参数值非法", paramName, paramValue, errorDetail);
    }
}
