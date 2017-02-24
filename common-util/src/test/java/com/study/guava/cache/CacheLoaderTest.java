package com.study.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Created by wangzhj on 2016/12/15.
 * <p>
 * Guava Cache是单个应用运行时的本地缓存。它不把数据存放到文件或外部服务器。
 * 如果这不符合你的需求，请尝试Memcached这类工具
 */
public class CacheLoaderTest {

    private static final Logger logger = LoggerFactory.getLogger(CacheLoaderTest.class);

    private static LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
//            .initialCapacity(100)
//            .maximumSize(1000)
//            .refreshAfterWrite(10, TimeUnit.SECONDS)
//            .expireAfterWrite(10, TimeUnit.SECONDS)
//            .expireAfterAccess(10, TimeUnit.SECONDS)
//            .ticker(Ticker.systemTicker())
//            .removalListener(new RemovalListener<Object, Object>() {
//                @Override
//                public void onRemoval(RemovalNotification<Object, Object> notification) {
//                    logger.info(notification.getKey() + " was removed, cause is " + notification.getCause());
//                }
//            })
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    logger.info("load into cache!");
                    return "hello " + key + "!";
                }

          /*      @Override
                public Map<String, String> loadAll(Iterable<? extends String> keys) throws Exception {
                    logger.info("load all into cache!");
                    return super.loadAll(keys);
                }*/
            });

    @Test
    public void test_get() throws Exception {
        try {
            logger.info("jerry value:" + loadingCache.get("jerry"));
        } catch (Exception ex) {

        }
    }

    @Test
    public void test_get_callable() throws Exception {
        try {
            logger.info("jerry value:" + loadingCache.get("jerry", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "CALLLL";
                }
            }));
            logger.info("jerry value:" + loadingCache.get("jerry"));
        } catch (Exception ex) {

        }
    }

    @Test
    public void test_getAll() {
        try {
            logger.info("jerry value:" + loadingCache.getAll(Arrays.asList("123", "123123")));
        } catch (Exception ex) {

        }
    }

    @Test
    public void test_getIfPresent() throws Exception {
        try {
            logger.info("jerry value:" + loadingCache.getIfPresent("jerry"));

            loadingCache.put("jerry", "自己放置的值！");
            logger.info("jerry value:" + loadingCache.getIfPresent("jerry"));
        } catch (Exception ex) {

        }
    }

    @Test
    public void test_getAllPresent() {
        try {
            logger.info("jerry value:" + loadingCache.getAllPresent(Arrays.asList("123", "123123")));
        } catch (Exception ex) {

        }
    }
}
