package com.company.exception.my.business;

import com.company.exception.base.BusinessException;

/**
 * 已存在异常
 *
 * @author wangzhj
 */
public class AlreadyExistException extends BusinessException {

    public AlreadyExistException(String objName){
        super("2001", "[{0}]已存在", objName);
    }
}
