package com.company.exception.business;

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
