package com.company.project.common.exception.param;

import com.company.project.common.exception.BaseException;
import com.company.project.common.exception.ExceptionHandler;

/**
 * 参数异常
 *
 * @author wangzhj
 */
public class ParamException extends BaseException {

    /** 参数名称 */
    private String paramName = null;

    public ParamException(String paramName, String errorDesc){
        this(paramName, errorDesc, null);
    }

    public ParamException(String paramName, String errorCode, String errorDesc){
        super(errorCode, errorDesc, ExceptionHandler.getMessageOfParamException(paramName, errorCode, errorDesc), null);
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }
}
