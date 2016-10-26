package com.company.exception;

import com.company.exception.base.BaseException;
import com.company.exception.base.BusinessException;
import com.company.exception.base.ParamException;

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
