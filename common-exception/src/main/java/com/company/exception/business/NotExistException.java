package com.company.exception.business;

import com.company.exception.BusinessException;
import com.company.exception.MessageUtil;

/**
 * <p>不存在异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class NotExistException extends BusinessException {

    public NotExistException(String objName, String objValue) {
        super("2002", MessageUtil.format("business.error.notExist", objName, objValue));
    }
}
