package com.company.exception.util;

import com.company.exception.base.BaseException;
import com.company.exception.my.param.ParamEmptyValueException;
import com.company.exception.my.param.ParamException;
import com.company.exception.my.param.ParamFormatErrorException;
import com.company.exception.my.param.ParamValueIllegalException;

import java.text.MessageFormat;

/**
 * Created by wangzhj on 2016/9/20.
 */
public class ExceptionUtil {

    public static String parseParamException(BaseException baseEx) {
        ParamException paramEx = (ParamException) baseEx;
        String errorCode = paramEx.getErrorCode();
        String errorDesc = paramEx.getErrorDesc();
        String paramName = paramEx.getParamName();
        Object paramValue = paramEx.getParamValue();

        String value = null;
        if (paramEx instanceof ParamEmptyValueException) {
            value = MessageFormat.format(errorDesc, paramName);
        } else if (paramEx instanceof ParamFormatErrorException) {


        } else if (paramEx instanceof ParamValueIllegalException) {


        }

        return value;
    }

    public static void main(String[] args) {
        float i = 0.000f;
        String str = "0.0";
        System.out.println(Float.valueOf(str) > 0);
    }
}