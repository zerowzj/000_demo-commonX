package com.company.exception.param;

import com.company.exception.ParamException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>Title: LengthErrorException<／p>
 * <p>Description: ${DESC}<／p>
 *
 * @author wangzhj
 * @time 2016-11-09 13:31
 */
public class LengthErrorException extends ParamException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "param.error.desc.lengthError";

    private static final String MSG_KEY = "param.error.msg.lengthError";

    public LengthErrorException(String paramName) {
        super(ERROR_CODE, format(DESC_KEY, paramName), format(DESC_KEY, paramName));
    }

    public LengthErrorException(String paramName, int minLength, int maxLength) {
        super(ERROR_CODE, format(DESC_KEY, paramName), format(MSG_KEY, paramName, minLength, maxLength));
    }
}
