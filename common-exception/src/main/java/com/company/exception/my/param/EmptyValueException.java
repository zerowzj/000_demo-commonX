package com.company.exception.my.param;

/**
 * 参数空值异常
 *
 * @author wangzhj
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String paramName){
        super("10001", "参数为空[{0}]", paramName);
    }
}
