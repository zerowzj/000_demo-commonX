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
     * @param clazz
     * @return boolean
     */
    public boolean support(Class<?> clazz);

    /**
     * 验证
     *
     * @param param
     * @param value
     * @return boolean
     */
    public void validate(Param param, Object value);

}
