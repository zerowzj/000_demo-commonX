package com.study.jdk.jcf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhj on 2016/12/21.
 */
public class ListTest {

    public static final Logger logger = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void test_ArrayList(){

        List list = new ArrayList<>(1);

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

    }

    @Test
    public void test_Vector(){

    }

    @Test
    public void test_LinkedList(){

    }

}
