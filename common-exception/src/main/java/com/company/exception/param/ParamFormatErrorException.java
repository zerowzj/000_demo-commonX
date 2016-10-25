package com.company.exception.param;

/**
 * 参数格式错误异常
 *
 * @author wangzhj
 */
public class ParamFormatErrorException extends ParamException {

    public ParamFormatErrorException(String paramName, Object paramValue){
        super("1002", "参数格式错误[{0}, {1}]", paramName, paramValue);
    }
}
