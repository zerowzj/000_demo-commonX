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
     * @return String
     */
    public static String buildMessage(String errorDesc, String paramName, Object paramValue, String message) {
        if (message == null) {
            String pattern = errorDesc + "[{0}]";
            message = MessageFormat.format(pattern, paramName);
        }
        return message;
    }

    /**
     * 格式化错误描述
     *
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
