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
        String errorDetail = ex.getErrorDetail();

        List argLt = new ArrayList<>();
        if (ex instanceof ParamException) {
            ParamException pex = (ParamException) ex;
            //参数名
            argLt.add(pex.getParamName());
            //参数值
            if (pex instanceof FormatErrorException || pex instanceof ValueIllegalException) {
                argLt.add(pex.getParamValue());
            }
            errorDetail = MessageFormat.format(errorDetail, argLt.toArray(new String[]{}));
        } else if (ex instanceof BusinessException) {
            BusinessException bex = (BusinessException) ex;
        }

        return errorDetail;
    }
}
