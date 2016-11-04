package com.company.exception;

/**
 * Exception Util
 *
 * @author wangzhj
 */
public abstract class ExceptionUtil {

    /**
     * 构造ParamException Message
     *
     * @return String
     */
    public static String buildParamExceptionMessage(String key, String paramName, Object paramValue, String message) {
        if (message == null) {
            message = MessageUtil.format(key, paramName, paramValue);
        }
        return message;
    }
}
