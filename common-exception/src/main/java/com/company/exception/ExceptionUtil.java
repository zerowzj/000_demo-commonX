package com.company.exception;

/**
 * Created by wangzhj on 2016/10/31.
 */
public abstract class ExceptionUtil {

    public static String getErrorDesc(BaseException ex) {

        return null;
    }

    public static String getFmtErrorDesc(BaseException ex) {
        String errorDesc = ex.getErrorDesc();
        String fmtErrorDesc = ex.getFmtErrorDesc();
        if (ex instanceof ParamException) {
            ParamException pex = (ParamException) ex;
            pex.getParamName();
            pex.getParamValue();

        } else if(ex instanceof BusinessException){

        }
        return null;
    }
}
