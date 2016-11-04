package com.company.exception.business;

import com.company.exception.BusinessException;
import com.company.exception.ExceptionUtil;

import java.text.MessageFormat;

/**
 * 不匹配异常
 *
 * @author wangzhj
 */
public class NotMatchException extends BusinessException {

    public NotMatchException(String objName1, String objName2) {
        super("2002", ExceptionUtil.formatErrorDesc("[{0}]和[{1}]不匹配", objName1, objName2));
    }
}
