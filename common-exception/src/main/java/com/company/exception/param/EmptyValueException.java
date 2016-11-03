package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * 参数空值异常
 *
 * @author wangzhj
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String paramName) {
        this(paramName, null);
    }

    public EmptyValueException(String paramName, String message) {
        super("1001", "参数不存在或值为空", paramName, message);
    }
}
