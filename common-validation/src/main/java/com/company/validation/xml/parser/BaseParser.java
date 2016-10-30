package com.company.validation.xml.parser;

import com.company.validation.xml.rule.BaseRule;
import com.company.validation.xml.rule.Rule;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * Created by wangzhj on 2016/10/30.
 */
public abstract class BaseParser implements Parser {

    @Override
    public Rule doParse(Element ele) {
        Rule rule = parse(ele);

        BaseRule baseRule = (BaseRule) rule;
        //获取值
        Attribute notEmptyAttr = ele.attribute("notEmpty");
        if(notEmptyAttr != null){
            baseRule.setNotEmpty(true);
        }

        return baseRule;
    }

    public abstract Rule parse(Element ele);
}
