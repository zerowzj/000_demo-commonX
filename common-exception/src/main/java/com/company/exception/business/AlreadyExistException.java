package com.company.exception.business;

import com.company.exception.BusinessException;

import static com.company.exception.MessageUtil.format;

/**
 * <p>已存在异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class AlreadyExistException extends BusinessException {

    private static final String ERROR_CODE = "2001";

    private static final String DESC_KEY = "business.error.alreadyExist";

    public AlreadyExistException(String objName, String objValue) {
        super(ERROR_CODE, format(DESC_KEY, objName, objValue));
    }
}
