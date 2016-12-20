package com.study.guava.collections;

import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 18:22
 */
public class MapTest {

    private static final Logger logger = LoggerFactory.getLogger(MapTest.class);

    @Test
    public void test_ListMultimap(){
        ListMultimap<String, Object> map = ArrayListMultimap.create();
        map.put("Fruits", "Bannana");
        map.put("Fruits", "Apple");
        map.put("Fruits", "Pear");
        map.put("Fruits", "Pear");

        Collection<Object> fruits = map.get("Fruits");
        logger.info(fruits.toString());
    }

    @Test
    public void test_SetMultimap(){
        SetMultimap map = HashMultimap.create();
        map.put("Fruits", "Bannana");
        map.put("Fruits", "Apple");
        map.put("Fruits", "Pear");
        map.put("Fruits", "Pear");

        Collection<Object> fruits = map.get("Fruits");
        logger.info(fruits.toString());
    }
}
