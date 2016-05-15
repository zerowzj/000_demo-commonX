package com.company.project.common.exception.business;
















/**
 * 非法操作异常
 *
 * @author wangzhj
 */
public class IllegalActionException extends BusinessException {

    public IllegalActionException(String targetName){
        this(targetName, null);
    }

    public IllegalActionException(String targetName, String errorCode){
        super(targetName, errorCode, "操作非法");
    }
}
