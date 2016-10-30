package com.company.validation.xml.validator;

import com.company.validation.xml.Param;

/**
 * Created by wangzhj on 2016/10/30.
 */
public class EnumValidator extends BaseValidator{

    @Override
    public boolean support(Object obj) {
        return false;
    }

    @Override
    public void validateCustom(Param param, Object value) {


    }
}
