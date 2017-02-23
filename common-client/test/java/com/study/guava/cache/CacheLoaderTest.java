package com.study.guava.cache;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/15.
 *
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
                public String load(String key) {
                    logger.info("load key[{}]'s value!", key);
                    String value = "hello " + key + "!";
                    return null;
                }
            });


    public static void main(String[] args) throws Exception {
        try {
            loadingCache.get("", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return null;
                }
            });

            logger.info("jerry value:" + loadingCache.getIfPresent("jerry"));
                logger.info("jerry value:" + loadingCache.get("jerry"));
            //Guava Cache的get方法先在本地缓存中取，如果不存在，则会触发load方法。但load方法不能返回null。
            logger.info("jerry value:" + loadingCache.get("jerry"));
        } catch (Exception ex) {

        }

    }
}
