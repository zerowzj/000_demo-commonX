package com.company.project.common.exception;

import com.company.project.common.exception.business.BusinessException;
import com.company.project.common.exception.param.ParamException;
import com.company.project.common.exception.system.SystemException;

/**
 * 异常解析器
 *
 * @author wangzhj
 */
public class ExceptionParser {

    public void parser(BaseException ex){

        if(ex instanceof ParamException){
            ParamException pex = (ParamException) ex;
        } else if(ex instanceof BusinessException){
            BusinessException bex = (BusinessException) ex;
        } else if(ex instanceof SystemException){
            SystemException sex = (SystemException) ex;
        }
    }

}
