package com.company.exception.business;

import com.company.exception.BusinessException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>过期异常</p>
 *
 * @author wangzhj
 * @time 2016-11-10 14:04
 */
public class ExpiredException extends BusinessException {

    private static final String ERROR_CODE = "2002";

    private static final String DESC_KEY = "business.error.expired";

    public ExpiredException(String objName) {
        super(ERROR_CODE, format(DESC_KEY, objName));
    }
}
