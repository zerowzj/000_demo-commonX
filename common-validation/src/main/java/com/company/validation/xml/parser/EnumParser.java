package com.company.validation.xml.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.company.validation.xml.Param;
import com.company.validation.xml.rule.EnumRule;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * 枚举类型解析器
 * 
 * @author wangzhj
 */
public class EnumParser implements Parser {

	/** 默认分割符 */
	private static String DEFAULT_SEPARATOR = ",";
	
	@Override
	public void parse(Element ele, Param param) {
		EnumRule type = new EnumRule();
		//获取分隔符
		String separator = DEFAULT_SEPARATOR;
		Attribute separatorAttr = ele.attribute("separator");
		if (separatorAttr != null) {
			separator = separatorAttr.getValue();
		}
		//获取值
		Attribute valuesAttr = ele.attribute("values");
		if (valuesAttr != null) {
//			String[] valueArr = StringUtil.split(valuesAttr.getValue(), separator);
//			Set<String> valueSet = new HashSet<String>(Arrays.asList(valueArr));
//			type.setValueSet(valueSet);
		}
	}
}
