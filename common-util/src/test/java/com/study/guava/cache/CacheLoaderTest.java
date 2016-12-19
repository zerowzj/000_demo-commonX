package com.study.guava.cache;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/15.
 */
public class CacheLoaderTest {

    private static final Logger logger = LoggerFactory.getLogger(CacheLoaderTest.class);

    private static CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
        @Override
        public String load(String key) throws Exception {
            logger.info("加载[{}]的值", key);
            String value = "hello " + key + "!";
            return value;
        }

        @Override
        public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
            return super.reload(key, oldValue);
        }

        @Override
        public Map<String, String> loadAll(Iterable<? extends String> keys) throws Exception {
            return super.loadAll(keys);
        }
    };

    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
//            .refreshAfterWrite(10, TimeUnit.SECONDS)
//            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build(cacheLoader);

    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                logger.info("jerry value:" + cache.get("jerry"));
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception ex) {

            }
        }
    }
}
