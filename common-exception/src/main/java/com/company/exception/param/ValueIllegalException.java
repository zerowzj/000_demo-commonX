package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * 参数值非法异常
 *
 * @author wangzhj
 */
public class ValueIllegalException extends ParamException {

    public ValueIllegalException(String paramName, Object paramValue) {
        super("1003", "参数值非法", "参数[{0}]值[{1}]非法", paramName, paramValue);
    }
}
