package com.company.exception.business;

import com.company.exception.BusinessException;
import com.company.exception.ExceptionUtil;

import java.text.MessageFormat;

/**
 * <p>Title: NonExistException<／p>
 * <p>Description: 不存在异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class NonExistException extends BusinessException {

    public NonExistException(String objName){
        super("2002", ExceptionUtil.formatErrorDesc("[{0}]不存在", objName));
    }

}
