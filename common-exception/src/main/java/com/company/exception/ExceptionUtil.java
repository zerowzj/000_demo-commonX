package com.company.exception;

import java.text.MessageFormat;

/**
 * Exception Util
 *
 * @author wangzhj
 */
public abstract class ExceptionUtil {

    /**
     * 构造ParamException Message
     *
     * @param errorCode
     * @param errorDesc
     * @param paramName
     * @param paramValue
     * @param message
     * @return String
     */
    public static String buildMessage(String errorCode, String errorDesc, String paramName, Object paramValue, String message) {
        if (message == null) {
            message = errorDesc + "[" + paramName + "]";
        }
        return message;
    }

    /**
     * 格式化错误描述
     *
     * @param pattern
     * @param args
     * @return String
     */
    public static String formatErrorDesc(String pattern, String... args) {
        for (String arg : args) {
            if (arg == null) {
                throw new IllegalArgumentException();
            }
        }
        return MessageFormat.format(pattern, args);
    }
}
