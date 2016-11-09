package com.company.exception.param;

import com.company.exception.MessageUtil;
import com.company.exception.ParamException;

/**
 * 非法枚举值异常
 *
 * @author wangzhj
 * @time 2016-11-09 10:08
 */
public class NotEnumValueException extends ParamException {

    public NotEnumValueException(String paramName) {
        super("1001", "参数值非法枚举值", paramName, MessageUtil.format("param.error.noEmpty", paramName));
    }
}
