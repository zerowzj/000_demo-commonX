package com.study.guava.string;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 15:47
 */
public class SplitterTest {

    @Test
    public void test_omitEmptyStrings(){
        String str = "aaa,ffdsfds,,,sdfsdf  ,,,sdfsd";
        List<String> tt = Splitter.on(",").omitEmptyStrings().splitToList(str);
        System.out.println(tt);
    }

    @Test
         public void test_trimResults(){
        String str = "aaa,ffdsfds,,,sdfsdf  ,,,sdfsd";
        List<String> tt = Splitter.on(",").trimResults().splitToList(str);
        System.out.println(tt);
    }

    @Test
    public void test_limit(){
        String str = "aaa,ffdsfds,sdfsdfsdfsd,aaaa";
        List<String> tt = Splitter.on(",").limit(3).splitToList(str);
        System.out.println(tt);
    }


    @Test
    public void test_withKeyValueSeparator(){
        String str = "key1=value1&key2=value2";
        Map<String, String> tt = Splitter.on("&").omitEmptyStrings().withKeyValueSeparator("=").split(str);
        System.out.println(tt);
    }
}
