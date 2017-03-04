package com.study.commons.pool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by wangzhj on 2017/2/24.
 */
public class ObjectPoolTest {

    @Test
    public void test() throws Exception {
        //资源池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(5);
        final GenericObjectPool<String> pool = new GenericObjectPool(new BasePooledObjectFactory<String>() {

            @Override
            public String create() throws Exception {
                String i = UUID.randomUUID().toString();
                System.out.println("make " + i + " success...");
                return i;
            }

            @Override
            public PooledObject<String> wrap(String obj) {
                System.out.println(obj);
                return new DefaultPooledObject<>(obj);
            }
        }, poolConfig);

        Executor executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);


            //获取资源对象
            String user = pool.borrowObject();
            //将获取的资源对象，返还给资源池
//            pool.returnObject(user);
            //输出资源对象
            System.out.println(user);
        }
    }
}
