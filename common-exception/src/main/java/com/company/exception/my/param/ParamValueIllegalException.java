package com.company.exception.my.param;

/**
 * 参数值非法异常
 *
 * @author wangzhj
 */
public class ParamValueIllegalException extends ParamException {

    public ParamValueIllegalException(String paramName, String paramValue){
        super("1003", "参数值非法[{0}, {1}]", paramName, paramValue);
    }
}
