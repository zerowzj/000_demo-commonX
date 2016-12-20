package com.study.guava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 18:24
 */
public class ListTest {

    @Test
    public void test_Lists(){
        List<String> strLt = Lists.newArrayList("a", "b");
    }

    public void test_ImmutableList(){
        ImmutableList<String> list = ImmutableList.of("1", "2");
    }
}
