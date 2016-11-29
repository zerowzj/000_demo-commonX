package com.study.guava.string;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 15:38
 */
public class JoinerTest {

    @Test
    public void test_skipNulls(){
        String str = Joiner.on(",").skipNulls().join("123", "abc", null, null);
        System.out.println(str);
    }

    @Test
    public void test_userForNull(){
        String str = Joiner.on(",").useForNull("空格").join("123", "abc", null, null);
        System.out.println(str);
    }

    @Test
    public void test_withKeyValueSeparator(){
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        String str = Joiner.on("&").withKeyValueSeparator("=").join(map);
        System.out.println(str);
    }
}
