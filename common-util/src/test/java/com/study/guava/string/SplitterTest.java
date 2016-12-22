package com.study.guava.string;

import com.google.common.base.Splitter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 15:47
 */
public class SplitterTest {

    private static final Logger logger = LoggerFactory.getLogger(SplitterTest.class);

    @Test
    public void test_omitEmptyStrings() {
        String str = "aaa,bbb,,,ddd";
        List<String> tt = Splitter.on(",").omitEmptyStrings().splitToList(str);
        logger.info(tt.toString());
    }

    @Test
    public void test_trimResults() {
        String str = "aaa, bbb,ccc ,ddd";
        List<String> tt = Splitter.on(",").trimResults().splitToList(str);
        logger.info(tt.toString());
    }

    @Test
    public void test_limit() {
        String str = "aaa,bbb,ccc,ddd";
        List<String> tt = Splitter.on(",").limit(3).splitToList(str);
        logger.info(tt.toString());
    }

    @Test
    public void test_withKeyValueSeparator() {
        String str = "key1=value1&key2=value2";
        Map<String, String> tt = Splitter.on("&").omitEmptyStrings().withKeyValueSeparator("=").split(str);
        logger.info(tt.toString());
    }
}
