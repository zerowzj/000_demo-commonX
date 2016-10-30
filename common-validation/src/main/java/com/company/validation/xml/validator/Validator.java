package com.company.validation.xml.validator;

import com.company.validation.xml.Param;

/**
 * Created by wangzhj on 2016/10/30.
 */
public interface Validator {

    public boolean support(Object obj);

    public void validate(Param param, Object value);

}
