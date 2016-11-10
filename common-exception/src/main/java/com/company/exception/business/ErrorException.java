package com.company.exception.business;

import com.company.exception.BusinessException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>错误异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-10 11:30
 */
public class ErrorException extends BusinessException {

    private static final String ERROR_CODE = "2002";

    private static final String DESC_KEY = "business.error.desc.error";

    private static final String MSG_KEY = "business.error.msg.error";

    public ErrorException(String objName) {
        super(ERROR_CODE, format(DESC_KEY, objName));
    }

    public ErrorException(String objName, String objValue) {
        super(ERROR_CODE, format(DESC_KEY, objName), format(MSG_KEY, objName, objValue));
    }
}
