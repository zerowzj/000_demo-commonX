package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * <p>日期格式错误<／p>
 *
 * @author wangzhj
 * @time 2016-11-09 10:52
 */
public class UrlFormatException extends ParamException {


    public UrlFormatException(){
        super("", "参数值日期格式错误",  null);
    }
}
