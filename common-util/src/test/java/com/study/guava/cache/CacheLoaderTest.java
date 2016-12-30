package com.study.guava.cache;

import com.google.common.base.Ticker;
import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/15.
 */
public class CacheLoaderTest {

    private static final Logger logger = LoggerFactory.getLogger(CacheLoaderTest.class);

    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
//            .initialCapacity(100)
//            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .expireAfterWrite(10, TimeUnit.SECONDS)
//            .expireAfterAccess(10, TimeUnit.SECONDS)
//            .ticker(Ticker.systemTicker())
            .removalListener(new RemovalListener<Object, Object>() {
                @Override
                public void onRemoval(RemovalNotification<Object, Object> notification) {
                    logger.info(notification.getKey() + " was removed, cause is " + notification.getCause());
                }
            })
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    logger.info("加载[{}]的值", key);
                    String value = "hello " + key + "!";
                    return String.valueOf(RandomUtils.nextInt(0, 10));
                }
            });

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
