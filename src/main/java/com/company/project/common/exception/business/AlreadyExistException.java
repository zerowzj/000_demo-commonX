package com.company.project.common.exception.business;

/**
 * 目标已存在异常
 *
 * @author wangzhj
 */
public class AlreadyExistException extends BusinessException {

    public AlreadyExistException(String targetName){
        this(targetName, null);
    }

    public AlreadyExistException(String targetName, String errorCode){
        super(targetName, errorCode, "已存在（重复）");
    }
}
