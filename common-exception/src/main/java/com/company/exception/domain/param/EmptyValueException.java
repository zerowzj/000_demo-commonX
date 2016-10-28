package com.company.exception.domain.param;

import com.company.exception.domain.ParamException;

/**
 * 参数空值异常
 *
 * @author wangzhj
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String paramName) {
        super("1001", "参数值为空", paramName);
    }
}
