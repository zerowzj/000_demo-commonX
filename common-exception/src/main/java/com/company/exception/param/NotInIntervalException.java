package com.company.exception.param;

import com.company.exception.MessageUtil;
import com.company.exception.ParamException;

/**
 * <p>Title: IntervalErrorException<／p>
 * <p>Description: ${DESC}<／p>
 *
 * @author wangzhj
 * @time 2016-11-09 10:09
 */
public class NotInIntervalException extends ParamException {

    private String start = null;

    private String end = null;

    public NotInIntervalException(String paramName) {
        super("1001", "参数不存在或值为空", paramName, MessageUtil.format("param.error.noEmpty", paramName));
    }
}
