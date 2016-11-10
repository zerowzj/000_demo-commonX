package com.company.exception.param;

import com.company.exception.ParamException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>日期格式错误</p>
 *
 * @author wangzhj
 * @time 2016-11-09 10:52
 */
public class DateFormatException extends ParamException {

    private static final String ERROR_CODE = "1002";

    private static final String DESC_KEY = "param.error.desc.lengthError";

    public DateFormatException(String paramName) {
        super(ERROR_CODE, format(DESC_KEY, paramName));
    }
}
