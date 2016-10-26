package com.company.exception;

import com.company.exception.base.BaseException;
import com.company.exception.base.ParamException;

/**
 * Created by wangzhj on 2016/10/26.
 */
public class ExceptionHandler {

    public static String getLoggerMsg(BaseException bex){

        if(bex instanceof ParamException){
            ParamException pex = (ParamException) bex;
            pex.getParamName();
            pex.getParamValue();
        }
        return null;
    }

}
