package com.company.project.common.exception.param;

/**
 * 参数格式错误异常
 *
 * @author wangzhj
 */
public class FormatErrorException extends ParamException {

    public FormatErrorException(String paramName) {
        this(paramName, null);
    }

    public FormatErrorException(String paramName, String errorCode) {
        super(paramName, errorCode, "参数格式错误");
    }
}
