package com.company.exception.business;

import com.company.exception.BusinessException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>未绑定异常</p>
 *
 * @author wangzhj
 * @time 2016-11-10 11:40
 */
public class NotBindException extends BusinessException {

    private static final String ERROR_CODE = "2002";

    private static final String DESC_KEY = "business.error.notBind";

    public NotBindException(String objName, String targetName) {
        super(ERROR_CODE, format(DESC_KEY, objName, targetName));
    }
}
