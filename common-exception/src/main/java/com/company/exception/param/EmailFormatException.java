package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-09 10:52
 */
public class EmailFormatException extends ParamException {


    public EmailFormatException(){
        super("", "参数值日期格式错误",  null);
    }
}
