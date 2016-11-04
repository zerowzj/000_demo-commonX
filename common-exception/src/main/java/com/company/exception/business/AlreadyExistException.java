package com.company.exception.business;

import com.company.exception.BusinessException;
import com.company.exception.ExceptionUtil;

import java.text.MessageFormat;

/**
 * <p>Title: AlreadyExistException<／p>
 * <p>Description: 已存在异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class AlreadyExistException extends BusinessException {

    public AlreadyExistException(String objName) {
        super("2001", ExceptionUtil.formatErrorDesc("[{0}]已存在", objName));
    }
}
