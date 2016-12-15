package com.study.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/15.
 */
public class CacheLoaderTest {

    private static final Logger logger = LoggerFactory.getLogger(CacheLoaderTest.class);

    @Test
    public void test() throws Exception {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .recordStats()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        logger.info("加载[{}]的值", key);
                        String value = "hello " + key + "!";
                        return value;
                    }


                });

        logger.info("jerry value:" + cache.get("jerry"));
        logger.info("jerry value:" + cache.get("jerry"));
        logger.info("jerry value:" + cache.get("jerry"));
        logger.info("jerry value:" + cache.get("jerry"));
        logger.info(cache.stats().toString());
    }
}
