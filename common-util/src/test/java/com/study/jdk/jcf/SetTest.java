package com.study.jdk.jcf;

import org.junit.Test;

/**
 * Created by wangzhj on 2016/12/21.
 */
public class SetTest {

    /**
     * HashSet使用的是相当复杂的方式来存储元素的，
     * 使用HashSet能够最快的获取集合中的元素，效率非常高（以空间换时间）。
     * 会根据hashcode和equals来庞端是否是同一个对象，
     * 如果hashcode一样，并且equals返回true，则是同一个对象，不能重复存放。
     */
    @Test
    public void test_HashSet() {

    }

    @Test
    public void test_TreeSet() {

    }
}
