package com.company.exception;

import com.company.exception.param.EmptyValueException;
import com.company.exception.param.FormatErrorException;
import com.company.exception.param.ValueIllegalException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

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
     * @param errorDetail
     * @return String
     */
    public static String buildMessage(String errorCode, String errorDesc, String errorDetail) {
        String message = errorDetail;
        if (errorDetail == null) {
            message = errorDesc + "[" + errorCode + "]";
        }
        return message;
    }
}
