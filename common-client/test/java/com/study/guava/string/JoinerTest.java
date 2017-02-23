package com.study.guava.string;

import com.google.common.base.Joiner;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 15:38
 */
public class JoinerTest {

    private static final Logger logger = LoggerFactory.getLogger(JoinerTest.class);

    @Test
    public void test_skipNulls(){
        String str = Joiner.on(",").skipNulls().join("123", "abc", null, null);
        logger.info(str);
    }

    @Test
    public void test_userForNull(){
        String str = Joiner.on(",").useForNull("空格").join("123", "abc", null, null);
        logger.info(str);
    }

    @Test
    public void test_withKeyValueSeparator(){
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String str = Joiner.on("&").withKeyValueSeparator("=").join(map);
        logger.info(str);
    }
}
