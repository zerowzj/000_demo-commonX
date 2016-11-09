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
public class NotIntervalValueException extends ParamException {

    /**  */
    private String begin = null;
    /**  */
    private String end = null;

    public NotIntervalValueException(String paramName) {
        super("1001", "参数值不在区间", paramName, MessageUtil.format("param.error.noEmpty", paramName));
    }
}
