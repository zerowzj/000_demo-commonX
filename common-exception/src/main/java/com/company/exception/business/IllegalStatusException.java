package com.company.exception.business;

import com.company.exception.BaseException;
import com.company.exception.BusinessException;
import com.company.exception.ExceptionUtil;

/**
 * <p>Title: IllegalStatusException<／p>
 * <p>Description: 非法状态异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class IllegalStatusException extends BusinessException {

    public IllegalStatusException(String objName, String status) {
        super("", ExceptionUtil.formatErrorDesc("[{0}]状态非法", objName, status));
    }
}
