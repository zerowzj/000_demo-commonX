package com.company.validation.xml.validator;

import com.company.validation.xml.parser.Parser;

/**
 * 验证器工厂
 *
 * @author wangzhj
 */
public class ValidatorFactory {

    /**
     * 获取类型解析器
     *
     * @param type
     * @return TypeParser
     */
    public static Validator getValidator(final String type) {
        Validator validator = null;
        if ("string".equals(type)) {
            validator = new StringValidator();
        } else if ("enum".equals(type)) {
            validator = new EnumValidator();
        }
        return validator;
    }
}
