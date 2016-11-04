package com.company.exception.business;

import com.company.exception.BusinessException;
import com.company.exception.ExceptionUtil;

import java.text.MessageFormat;

/**
 * 已存在异常
 *
 * @author wangzhj
 */
public class AlreadyExistException extends BusinessException {

    public AlreadyExistException(String objName) {
        super("2001", ExceptionUtil.formatErrorDesc("[{0}]已存在", objName));
    }
}
