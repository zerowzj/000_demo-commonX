package com.company.validation.xml.parser;

import com.company.validation.xml.rule.DateRule;
import com.company.validation.xml.rule.NumberRule;
import com.company.validation.xml.rule.Rule;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * 日期规则解析器
 *
 * @author wangzhj
 */
public class DateParser implements Parser {

    @Override
    public Rule parse(Element ele) {
        DateRule rule = new DateRule();
        //获取值
        Attribute formatAtt = ele.attribute("format");
        if (formatAtt != null) {
            rule.setFormat(formatAtt.getValue());
        }
        Attribute minDateAtt = ele.attribute("minDate");
        if (minDateAtt != null) {
            rule.setMinDate(minDateAtt.getValue());
        }
        Attribute maxDateAtt = ele.attribute("maxDate");
        if (maxDateAtt != null) {
            rule.setMaxDate(maxDateAtt.getValue());
        }
        return rule;
    }
}
