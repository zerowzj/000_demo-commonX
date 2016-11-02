package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * 参数空值异常
 *
 * @author wangzhj
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String errorDetail, String paramName) {
        super("1001", "参数值为空", errorDetail, paramName);
    }
}
