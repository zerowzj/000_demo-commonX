package com.company.exception.param;

import com.company.exception.MessageUtil;
import com.company.exception.ParamException;

/**
 * <p>参数不存在或空值异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class EmptyValueException extends ParamException {

    public EmptyValueException(String paramName) {
        super("1001", "参数不存在或值为空", paramName, MessageUtil.format("param.error.noEmpty", paramName));
    }
}
