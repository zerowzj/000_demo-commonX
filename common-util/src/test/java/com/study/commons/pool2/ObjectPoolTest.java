package com.study.commons.pool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

/**
 * Created by wangzhj on 2017/2/24.
 */
public class ObjectPoolTest {

    @Test
    public void test() throws Exception {
        //资源池配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMinIdle(2);
        GenericObjectPool<String> pool = new GenericObjectPool(new BasePooledObjectFactory<String>() {

            @Override
            public String create() throws Exception {
                return "123123";
            }

            @Override
            public PooledObject<String> wrap(String obj) {
                return new DefaultPooledObject<>(obj);
            }
        }, poolConfig);

        for(int i = 0; i < 3; i++) {
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
