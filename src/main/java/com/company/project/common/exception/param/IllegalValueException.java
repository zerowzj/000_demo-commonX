package com.company.project.common.exception.param;

/**
 * 参数值非法异常
 *
 * @author wangzhj
 */
public class IllegalValueException extends ParamException {

    public IllegalValueException(String paramName) {
        this(paramName, null);
    }

    public IllegalValueException(String paramName, String errorCode) {
        super(paramName, errorCode, "参数值非法");
    }
}
