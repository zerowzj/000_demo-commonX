package com.company.validation.xml;

import com.company.validation.xml.parser.Parser;
import com.company.validation.xml.parser.ParserFactory;
import com.company.validation.xml.rule.Rule;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数集合解析器
 *
 * @author wangzhj
 */
public class ParamSetParser {

    private static final String PARAM_CONFIG_DIR = "params";

    private static Map<String, ParamSet> PARAM_SET_MAP = new HashMap<>();

    static {
        load();
    }

    public static void load() {
        File configDir = new File(ParamSetParser.class.getResource("/").getPath() + "/" + PARAM_CONFIG_DIR);
        File[] fileArr = configDir.listFiles();
        for (File file : fileArr) {
            Element root = getRoot(file);
            parse(root);
        }
    }

    private static Element getRoot(final File fileName) {
        SAXReader reader = new SAXReader();
        Document doc = null;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(fileName);
            doc = reader.read(fi);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Element root = doc.getRootElement();
        return root;
    }

    private static void parse(final Element root) {
        //param-set元素
        List<Element> paramSetEleLt = root.elements();
        ParamSet paramSet = null;
        for (Element paramSetEle : paramSetEleLt) {
            paramSet = new ParamSet();
            //key属性
            Attribute keyAtt = paramSetEle.attribute("key");
            String key = keyAtt.getValue();

            //param元素
            List<Element> paramEleLt = paramSetEle.elements();
            Param param = null;
            List<Param> paramLt = new ArrayList<>();
            for (Element paramEle : paramEleLt) {
                param = new Param();
                //name属性
                Attribute nameAttr = paramEle.attribute("name");
                param.setParamName(nameAttr.getValue());
                //notEmpty属性
                Attribute notEmptyAtt = paramEle.attribute("notEmpty");
                String notEmpty = notEmptyAtt.getValue();
                if (notEmpty == null) {
                    param.setNotEmpty(false);
                } else {
                    param.setNotEmpty(true);
                }
                //规则元素
                List<Rule> ruleLt = new ArrayList<>();
                List<Element> eleLt = paramEle.elements();
                for (Element ele : eleLt) {
                    String eleName = ele.getName();
                    Parser parser = ParserFactory.getParser(eleName);
                    Rule rule = parser.parse(ele);

                    ruleLt.add(rule);
                }
                param.setRule(ruleLt.get(0));

                paramLt.add(param);
            }
            paramSet.setKey(key);
            paramSet.setParamLt(paramLt);

            PARAM_SET_MAP.put(key, paramSet);
        }
    }

    /**
     * 获取参数集映射
     *
     * @return Map<String, ParamSet>
     */
    public static Map<String, ParamSet> getParamSetMap() {
        return PARAM_SET_MAP;
    }
}
