package com.study.guava.collections;

import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.Collection;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 18:22
 */
public class MapTest {

    @Test
    public void test_ArrayListMultimap(){
        ArrayListMultimap<String, Object> map = ArrayListMultimap.create();
        map.put("Fruits", "Bannana");
        map.put("Fruits", "Apple");
        map.put("Fruits", "Pear");
        map.put("Fruits", "Pear");

        Collection<Object> fruits = map.get("Fruits");
        System.out.println(fruits);
    }

    @Test
    public void test_SetMultimap(){

    }
}
