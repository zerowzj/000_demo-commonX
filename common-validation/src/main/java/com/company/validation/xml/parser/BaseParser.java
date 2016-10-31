package com.company.validation.xml.parser;

import com.company.validation.xml.rule.Rule;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * Created by wangzhj on 2016/10/30.
 */
public abstract class BaseParser implements Parser {

    @Override
    public Rule parse(Element ele) {
        //
        Rule rule = parseCustom(ele);
        //获取值
        Attribute notEmptyAttr = ele.attribute("notEmpty");
//        if(notEmptyAttr != null){
            rule.setNotEmpty(true);
//        }

        return rule;
    }

    /**
     * 解析规则
     *
     * @param ele
     * @return Rule
     */
    public abstract Rule parseCustom(Element ele);
}
