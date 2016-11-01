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
     * @return Validator
     */
    public static Validator getValidator(String type) {
        Validator validator = null;
        if ("StringRule".equals(type)) {
            validator = new StringValidator();
        } else if ("EnumRule".equals(type)) {
            validator = new EnumValidator();
        } else if ("NumberRule".equals(type)) {
            validator = new NumberValidator();
        } else if ("DateRule".equals(type)) {
            validator = new DateValidator();
        }
        return validator;
    }
}
