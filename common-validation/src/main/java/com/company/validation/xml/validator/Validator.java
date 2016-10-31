package com.company.validation.xml.validator;

import com.company.validation.xml.Param;

/**
 * 验证器
 *
 * @author wangzhj
 */
public interface Validator {

    /**
     * 支持
     *
     * @param obj
     * @return boolean
     */
    public boolean support(Object obj);

    /**
     * 验证
     *
     * @param param
     * @param value
     * @return boolean
     */
    public void validate(Param param, Object value);

}
