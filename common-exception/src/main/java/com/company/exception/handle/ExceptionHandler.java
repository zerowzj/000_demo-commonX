package com.company.exception.handle;

import com.company.exception.domain.BaseException;
import com.company.exception.domain.BusinessException;
import com.company.exception.domain.ParamException;

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
