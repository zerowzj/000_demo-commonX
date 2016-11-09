package com.company.exception.param;

import com.company.exception.MessageUtil;
import com.company.exception.ParamException;

/**
 * <p>Title: EnumValueErrorException<／p>
 * <p>Description: ${DESC}<／p>
 *
 * @author wangzhj
 * @time 2016-11-09 10:08
 */
public class NotEnumException extends ParamException {

    public NotEnumException(String paramName) {
        super("1001", "参数不存在或值为空", paramName, MessageUtil.format("param.error.noEmpty", paramName));
    }
}
