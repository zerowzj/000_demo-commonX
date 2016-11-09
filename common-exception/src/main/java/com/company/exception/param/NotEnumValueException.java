package com.company.exception.param;

import com.company.exception.ParamException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>非法枚举值异常</p>
 *
 * @author wangzhj
 * @time 2016-11-09 10:08
 */
public class NotEnumValueException extends ParamException {

    private static final String ERROR_CODE = "1001";

    private static final String DESC_KEY = "param.error.desc.notEnum";

    private static final String MSG_KEY = "param.error.msg.notEnum";

    public NotEnumValueException(String paramName) {
        super(ERROR_CODE, format(DESC_KEY, paramName), format(DESC_KEY, paramName));
    }

    public NotEnumValueException(String paramName, Object enumValue) {
        super(ERROR_CODE, format(DESC_KEY, paramName), format(MSG_KEY, paramName, enumValue));
    }
}
