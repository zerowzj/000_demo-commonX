package com.company.exception.my.param;

import com.company.exception.base.ParamException;

/**
 * 参数空值异常
 *
 * @author wangzhj
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String paramName) {
        super("1001", "参数为空", paramName);
    }
}
