package com.company.exception.param;

import com.company.exception.ParamException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>非法区间值异常</p>
 *
 * @author wangzhj
 * @time 2016-11-09 10:09
 */
public class NotIntervalValueException extends ParamException {

    private static final String ERROR_CODE = "1001";

    private static final String DESC_KEY = "param.error.desc.notInterval";

    private static final String MSG_KEY = "param.error.msg.notInterval";

    /**
     * 构造非法区间值异常
     *
     * @param paramName 参数名称
     */
    public NotIntervalValueException(String paramName) {
        super(ERROR_CODE, format(DESC_KEY, paramName));
    }

    /**
     * 构造非法区间值异常
     *
     * @param paramName  参数名称
     * @param beginValue 参数名称
     * @param endValue   参数名称
     */
    public NotIntervalValueException(String paramName, Object beginValue, Object endValue) {
        super(ERROR_CODE, format(DESC_KEY, paramName), format(MSG_KEY, paramName));
    }
}
