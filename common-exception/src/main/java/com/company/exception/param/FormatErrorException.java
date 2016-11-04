package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * <p>Title: EmptyValueException<／p>
 * <p>Description: 参数格式错误异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class FormatErrorException extends ParamException {

    public FormatErrorException(String paramName, Object paramValue) {
        this(paramName, paramValue, null);
    }

    public FormatErrorException(String paramName, Object paramValue, String message) {
        super("1002", "参数值格式错误", paramName, paramValue, message);
    }
}
