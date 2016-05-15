package com.company.project.common.exception.param;

/**
 * 参数值空异常
 *
 * @author wangzhj
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String paramName) {
        this(paramName, null);
    }

    public EmptyValueException(String paramName, String errorCode) {
        super(paramName, errorCode, "参数值为空");
    }
}
