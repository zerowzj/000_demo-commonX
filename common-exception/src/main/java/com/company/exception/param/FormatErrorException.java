package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * 参数格式错误异常
 *
 * @author wangzhj
 */
public class FormatErrorException extends ParamException {

    public FormatErrorException(String paramName, Object paramValue) {
        super("1002", "参数值格式错误", paramName, paramValue);
    }
}
