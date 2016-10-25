package com.company.exception.my.param;

import com.company.exception.base.ParamException;

/**
 * 参数值非法异常
 *
 * @author wangzhj
 */
public class ValueIllegalException extends ParamException {

    public ValueIllegalException(String paramName, String paramValue){
        super("1003", "参数值非法[{0}, {1}]", paramName, paramValue);
    }
}
