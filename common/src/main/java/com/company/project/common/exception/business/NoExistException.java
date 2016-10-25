package com.company.project.common.exception.business;

/**
 * 目标不存在异常
 *
 * @author wangzhj
 */
public class NoExistException extends BusinessException {

    public NoExistException(String targetName){
        this(targetName, null);
    }

    public NoExistException(String targetName, String errorCode){
        super(targetName, errorCode, "不存在");
    }
}
