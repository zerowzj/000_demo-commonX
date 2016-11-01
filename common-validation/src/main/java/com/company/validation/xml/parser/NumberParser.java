package com.company.validation.xml.parser;

import com.company.validation.xml.rule.EnumRule;
import com.company.validation.xml.rule.NumberRule;
import com.company.validation.xml.rule.Rule;
import com.google.common.base.Splitter;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.List;

/**
 * 数字规则解析器
 *
 * @author wangzhj
 */
public class NumberParser implements Parser {

    @Override
    public Rule parse(Element ele) {
        NumberRule rule = new NumberRule();
        //获取值
        Attribute precisionAtt = ele.attribute("precision");
        if (precisionAtt != null) {
            rule.setPrecision(Integer.valueOf(precisionAtt.getValue()));
        }
        Attribute minValueAtt = ele.attribute("minValue");
        if (minValueAtt != null) {
            rule.setMinValue(minValueAtt.getValue());
        }
        Attribute maxValueAtt = ele.attribute("maxValue");
        if (maxValueAtt != null) {
            rule.setMaxValue(maxValueAtt.getValue());
        }
        return rule;
    }
}
