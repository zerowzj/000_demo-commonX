package com.study.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.Callables;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by wangzhj on 2016/12/15.
 */
public class CacheTest {

    private static final Logger logger = LoggerFactory.getLogger(LoadingCacheTest.class);

    Cache<String, String> cache = CacheBuilder.newBuilder().build();

    @Test
    public void test_get_callable() throws Exception {
        try {
            logger.info("jerry value:" + cache.get("jerry", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "call执行的值！";
                }
            }));

            //同步方式获取不存在的key缓存
            Callables.returning("");
        } catch (Exception ex) {

        }
    }

    @Test
    public void test_getIfPresent() throws Exception {
        try {
            logger.info("jerry value:" + cache.getIfPresent("jerry"));

            cache.put("jerry", "自己放置的值！");
            logger.info("jerry value:" + cache.getIfPresent("jerry"));
        } catch (Exception ex) {

        }
    }
}
