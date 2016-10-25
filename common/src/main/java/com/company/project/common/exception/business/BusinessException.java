package com.company.project.common.exception.business;

import com.company.project.common.exception.BaseException;
import com.company.project.common.exception.ExceptionHandler;

/**
 * 业务异常
 *
 * @author wangzhj
 */
public class BusinessException extends BaseException {

    /** 目标名称 */
    private String targetName = null;

    public BusinessException(String targetName, String errorDesc){
        this(targetName, null, errorDesc);
    }

    public BusinessException(String targetName, String errorCode, String errorDesc){
        super(errorCode, errorDesc, ExceptionHandler.getMsgOfBusinessException(targetName, errorCode, errorDesc), null);
    }

    public String getTargetName() {
        return targetName;
    }
}
