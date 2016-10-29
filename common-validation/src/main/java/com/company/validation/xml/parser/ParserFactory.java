package com.company.validation.xml.parser;

/**
 * 解析器工厂
 *
 * @author wangzhj
 */
public class ParserFactory {

    /**
     * 获取类型解析器
     *
     * @param type
     * @return TypeParser
     */
    public static Parser getParser(final String type) {
        Parser parser = null;
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
        return parser;
    }
}
