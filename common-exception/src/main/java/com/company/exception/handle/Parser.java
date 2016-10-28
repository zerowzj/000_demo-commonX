package com.company.exception.handle;

import com.company.exception.domain.AuthException;
import com.company.exception.domain.BaseException;
import com.company.exception.domain.BusinessException;
import com.company.exception.domain.ParamException;
import com.google.common.base.Joiner;

/**
 *
 *
 * @author  wangzhj
 */
public class Parser {


    public static String getLogMsg() {

    }

    public String handle(BaseException ex) {
        //获取错误码和错误描述
        String errorCode = ex.getErrorCode();
        String errorDesc = ex.getErrorDesc();
        //
        if (ex instanceof AuthException) {


        } else if (ex instanceof ParamException) {
            ParamException pex = (ParamException) ex;
            pex.getParamName();
            pex.getParamValue();

        } else if (ex instanceof BusinessException) {
            BusinessException bex = (BusinessException) ex;
        }


    }

    private String getFormat(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= count; i++) {
            sb.append("{").append(i).append("}, ");
        }
        return "[" + sb.substring(0, sb.length() - 2) + "]";
    }
}
