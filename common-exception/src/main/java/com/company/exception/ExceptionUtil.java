package com.company.exception;

import com.company.exception.param.EmptyValueException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhj on 2016/10/31.
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
        List argLt = new ArrayList<>();
        if (ex instanceof ParamException) {
            ParamException pex = (ParamException) ex;
            //参数名
            argLt.add(pex.getParamName());
            //参数值
            if (!(pex instanceof EmptyValueException)) {
                argLt.add(pex.getParamValue());
            }
            pex.getParamValue();
        }
        String errorDetail = ex.getErrorDetail();
        return MessageFormat.format(errorDetail, argLt.toArray(new String[]{}));
    }
}
