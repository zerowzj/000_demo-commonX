package com.company.exception;

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

    public ParamException(String errorCode, String errorDesc, String paramName, String errorDetail) {
        this(errorCode, errorDesc, paramName, null, errorDetail);
    }

    public ParamException(String errorCode, String errorDesc, String paramName, Object paramValue, String errorDetail) {
        super(errorCode, errorDesc, errorDetail);
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
