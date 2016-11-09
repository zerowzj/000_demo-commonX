package com.company.exception.param;

import com.company.exception.ParamException;

/**
 * <p>Title: LengthErrorException<／p>
 * <p>Description: ${DESC}<／p>
 *
 * @author wangzhj
 * @time 2016-11-09 13:31
 */
public class LengthErrorException extends ParamException {

    public LengthErrorException(String paramName){
        super("", "参数值长度错误", paramName, null);
    }
}
