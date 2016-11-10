package com.company.exception.param;

import com.company.exception.ParamException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>长度异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-09 13:31
 */
public class LengthException extends ParamException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "param.error.desc.lengthError";

    private static final String MSG_KEY = "param.error.msg.lengthError";

    public LengthException(String paramName) {
        super(ERROR_CODE, format(DESC_KEY, paramName));
    }

    public LengthException(String paramName, Integer minLength, Integer maxLength) {
        super(ERROR_CODE, format(DESC_KEY, paramName), format(MSG_KEY, paramName, minLength, maxLength));
    }
}
