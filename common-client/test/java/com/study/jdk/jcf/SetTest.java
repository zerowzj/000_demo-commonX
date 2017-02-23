package com.study.jdk.jcf;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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

        Set<String> set = new HashSet<>(1);

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");

        for(String str : set){
            System.out.println(str);
        }
    }

    @Test
    public void test_TreeSet() {

        Set<String> set = new TreeSet<>();

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");

        for(String str : set){
            System.out.println(str);
        }
    }
}
