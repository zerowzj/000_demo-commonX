package com.company.exception;

/**
 * Exception Util
 *
 * @author wangzhj
 */
public abstract class ExceptionUtil {

    /**
     * 获取异常描述
     *
     * @param ex
     * @return String
     */
    public static String getErrorDesc(BaseException ex) {
        String errorDesc = ex.getErrorDesc();
        return errorDesc;
    }

    /**
     * 获取异常详细
     *
     * @param ex
     * @return String
     */
    public static String getErrorDetail(BaseException ex) {
        String errorDetail = null;

        if (ex instanceof ParamException) {
            errorDetail = ex.getMessage();
        } else if (ex instanceof BusinessException) {
            BusinessException bex = (BusinessException) ex;
        }

        return errorDetail;
    }

    /**
     * 获取异常详细
     *
     * @param errorCode
     * @param errorDesc
     * @param message
     * @return String
     */
    public static String buildMessage(String errorCode, String errorDesc, String message) {
        if (message == null) {
            message = errorDesc + "[" + errorCode + "]";
        }
        return message;
    }

    /**
     * 获取异常详细
     *
     * @param errorCode
     * @param errorDesc
     * @param paramName
     * @param message
     * @return String
     */
    public static String buildMessage(String errorCode, String errorDesc, String paramName, String message) {
        if (message == null) {
            message = errorDesc + "[" + errorCode + "]";
        }
        return message;
    }
}
