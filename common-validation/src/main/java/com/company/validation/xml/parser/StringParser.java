package com.company.validation.xml.parser;

import com.company.validation.xml.rule.EnumRule;
import com.company.validation.xml.rule.Rule;
import com.company.validation.xml.rule.StringRule;
import com.google.common.base.Splitter;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.List;

/**
 * 字符串规则解析器
 *
 * @author wangzhj
 */
public class StringParser implements Parser {

    @Override
    public Rule parse(Element ele) {
        StringRule rule = new StringRule();
        //获取值
        Attribute minLengthAtt = ele.attribute("minLength");
        if (minLengthAtt != null) {
            rule.setMinLength(Integer.valueOf(minLengthAtt.getValue()));

        }
        Attribute maxLengthAtt = ele.attribute("maxLength");
        if (maxLengthAtt != null) {
            rule.setMaxLength(Integer.valueOf(maxLengthAtt.getValue()));
        }
        return rule;
    }
}
