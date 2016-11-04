package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * <p>Title: EmptyValueException<／p>
 * <p>Description: 参数不存在或空值异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String paramName) {
        this(paramName, null);
    }

    public EmptyValueException(String paramName, String message) {
        super("1001", "参数不存在或值为空", paramName, message);
    }
}
