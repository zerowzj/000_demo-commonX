package com.company.exception.domain;

/**
 * 参数异常
 *
 * @author wangzhj
 */
public class ParamException extends BaseException {

    /** 参数名 */
    private String paramName = null;
    /** 参数值 */
    private Object paramValue = null;

    public ParamException(String errorCode, String errorDesc, String fmtErrorDesc, String paramName){
        this(errorCode, errorDesc, fmtErrorDesc, paramName, null);
    }

    public ParamException(String errorCode, String errorDesc, String fmtErrorDesc,String paramName, Object paramValue){
        super(errorCode, errorDesc, fmtErrorDesc);
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
