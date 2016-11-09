package com.company.exception.param;

import com.company.exception.ParamException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>参数不存在或空值异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class EmptyValueException extends ParamException {

    private static final String ERROR_CODE = "1001";

    private static final String DESC_KEY = "param.error.notEmpty";

    public EmptyValueException(String paramName) {
        super(ERROR_CODE, format(DESC_KEY, paramName), format(DESC_KEY, paramName));
    }
}
