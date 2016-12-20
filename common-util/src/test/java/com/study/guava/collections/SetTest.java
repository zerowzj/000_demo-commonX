package com.study.guava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 18:24
 */
public class SetTest {

    private static final Logger logger = LoggerFactory.getLogger(SetTest.class);

    @Test
    public void test_HashMultiset(){
        HashMultiset<String> set = HashMultiset.create();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");

        set.setCount("b", 9);

        for(String str : set.elementSet()){
            logger.info("key[{}] = {}", str, set.count(str));
        }

        for(Multiset.Entry<String> entry : set.entrySet()){
            logger.info("key[{}] = {}", entry.getElement(), entry.getCount());
        }
    }
}
