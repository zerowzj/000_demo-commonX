package com.company.exception.domain.business;

import com.company.exception.domain.BusinessException;

/**
 * 不存在异常
 *
 * @author wangzhj
 */
public class NonExistException extends BusinessException {

    public NonExistException(String objName){
        super("2002", "[{0}]不存在", objName);
    }
}
