package com.study.commons.pool2;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

/**
 * Created by wangzhj on 2017/2/24.
 */
public class KeyedObjectPoolTest {

    @Test
    public void test() throws Exception {
        GenericKeyedObjectPool pool = new GenericKeyedObjectPool(new BaseKeyedPooledObjectFactory<String, String>() {
            @Override
            public String create(String key) throws Exception {
                System.out.println("create");
                return "sssssssssssss";
            }

            @Override
            public PooledObject<String> wrap(String value) {
                System.out.println("wrap");
                return new DefaultPooledObject(value);
            }
        });

        pool.addObject("123");

        System.out.println( pool.borrowObject("123"));
    }
}
