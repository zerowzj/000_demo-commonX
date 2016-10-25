package com.company.exception.my.param;

import com.company.exception.base.BaseException;

/**
 * 参数异常
 *
 * @author wangzhj
 */
public class ParamException extends BaseException {

    /** 参数名称 */
    private String paramName = null;
    /** 参数值 */
    private Object paramValue = null;

    public ParamException(String errorCode, String errorDesc, String paramName){
        this(errorCode, errorDesc, paramName, null);
    }

    public ParamException(String errorCode, String errorDesc, String paramName, Object paramValue){
        super(errorCode, errorDesc);
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public Object getParamValue() {
        return paramValue;
    }
}
