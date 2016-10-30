package com.company.validation.xml.validator;

import com.company.validation.xml.parser.Parser;

/**
 * Created by wangzhj on 2016/10/30.
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
        /*if ("string".equals(type)) {
            typeParser = new StringParser();
		} else if ("date".equals(type)) {
			typeParser = new DateParser();
		} else if ("enum".equals(type)) {
			typeParser = new EnumParser();
		} else if ("money".equals(type)) {
			typeParser = new MoneyParser();
		} else {

		}*/
        return validator;
    }
}
