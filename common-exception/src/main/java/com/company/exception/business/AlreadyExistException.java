package com.company.exception.business;

import com.company.exception.BusinessException;
import com.company.exception.MessageUtil;

/**
 * <p>已存在异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class AlreadyExistException extends BusinessException {

    public AlreadyExistException(String objName, String objValue) {
        super("2001", MessageUtil.format("business.error.alreadyExist", objName, objValue));
    }
}
