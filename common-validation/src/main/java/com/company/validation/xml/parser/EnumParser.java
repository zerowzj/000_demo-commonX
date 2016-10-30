package com.company.validation.xml.parser;

import com.company.validation.xml.rule.EnumRule;
import com.company.validation.xml.rule.Rule;
import com.google.common.base.Splitter;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.List;

/**
 * 枚举规则解析器
 * 
 * @author wangzhj
 */
public class EnumParser extends BaseParser {

	@Override
	public Rule parse(Element ele) {
		EnumRule rule = new EnumRule();
		//获取值
		Attribute valuesAttr = ele.attribute("values");
		if (valuesAttr != null) {
			Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
			List<String> strLt = splitter.splitToList(valuesAttr.getValue());
			rule.setValueLt(strLt);
		}
		return rule;
	}
}
