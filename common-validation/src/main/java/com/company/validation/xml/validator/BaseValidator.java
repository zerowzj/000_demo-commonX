package com.company.validation.xml.validator;

import com.company.validation.xml.Param;
import com.company.validation.xml.rule.BaseRule;
import com.company.validation.xml.rule.Rule;

import java.util.List;

/**
 * Created by wangzhj on 2016/10/30.
 */
public abstract class BaseValidator implements Validator {

    @Override
    public final void validate(Param param, Object value) {
        List<Rule> ruleLt = param.getRuleLt();
        BaseRule baseRule = null;
        if(baseRule.isNotEmpty() && value == null) {

        }

        validateCustom(param, value);
    }

    public abstract void validateCustom(Param param, Object value);
}
