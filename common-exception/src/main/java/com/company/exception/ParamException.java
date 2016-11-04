package com.company.exception;

/**
 * <p>Title: ParamException<／p>
 * <p>Description: 参数异常<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 11:55
 */
public class ParamException extends BaseException {

    /** 参数名 */
    private String paramName = null;
    /** 参数值 */
    private Object paramValue = null;

    public ParamException(String errorCode, String errorDesc, String paramName, String message) {
        this(errorCode, errorDesc, paramName, null, message);
    }

    public ParamException(String errorCode, String errorDesc, String paramName, Object paramValue, String message) {
        super(errorCode, errorDesc, ExceptionUtil.buildMessage(errorCode, errorDesc, paramName, paramValue, message));
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
