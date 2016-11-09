package com.company.exception.param;

import static com.company.exception.MessageUtil.format;

import com.company.exception.ParamException;


/**
 * 非法枚举值异常
 *
 * @author wangzhj
 * @time 2016-11-09 10:08
 */
public class NotEnumValueException extends ParamException {

    private static final String key = "param.error.notEnum";

    public NotEnumValueException(String paramName) {
        super("1001", "参数非法枚举值", paramName, format(key, paramName));
    }
}
