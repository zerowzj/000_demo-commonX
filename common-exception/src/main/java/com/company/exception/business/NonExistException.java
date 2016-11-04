package com.company.exception.business;

import com.company.exception.BusinessException;
import com.company.exception.ExceptionUtil;

import java.text.MessageFormat;

/**
 * 不存在异常
 *
 * @author wangzhj
 */
public class NonExistException extends BusinessException {

    public NonExistException(String objName){
        super("2002", ExceptionUtil.formatErrorDesc("[{0}]不存在", objName));
    }

}
