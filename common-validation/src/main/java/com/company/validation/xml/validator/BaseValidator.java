package com.company.validation.xml.validator;

import com.company.exception.domain.param.EmptyValueException;
import com.company.validation.xml.Param;
import com.company.validation.xml.rule.BaseRule;
import com.company.validation.xml.rule.Rule;

import java.util.List;

/**
 * 基础验证器
 *
 * @author wangzhj
 */
public abstract class BaseValidator implements Validator {

    @Override
    public final void validate(Param param, Object value) {
        List<Rule> ruleLt = param.getRuleLt();
        BaseRule baseRule = null;
        if (baseRule.isNotEmpty() && value == null) {
            throw new EmptyValueException(param.getParamName());
        }
        validateCustom(param, value);
    }

    /**
     * 自定义验证
     *
     * @param param
     * @param value
     * @return boolean
     */
    public abstract void validateCustom(Param param, Object value);
}
