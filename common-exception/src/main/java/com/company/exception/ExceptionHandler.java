package com.company.exception;

/**
 * Created by wangzhj on 2016/10/26.
 */
public class ExceptionHandler {

    public static String getLogMsg(BaseException ex){

        StringBuffer sb = new StringBuffer();
        if(ex instanceof ParamException){
            ParamException pex = (ParamException) ex;
            pex.getParamName();
            pex.getParamValue();
        } else if(ex instanceof BusinessException){
            BusinessException bex = (BusinessException)ex;
        }
        return null;
    }
}
