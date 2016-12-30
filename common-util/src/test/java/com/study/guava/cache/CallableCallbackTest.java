package com.study.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/15.
 */
public class CallableCallbackTest {

    private static final Logger logger = LoggerFactory.getLogger(CacheLoaderTest.class);

//    Cache<String, String> cache = CacheBuilder.newBuilder().

    public static void main(String[] args) throws Exception {
        while (true) {
            try {
//                logger.info("jerry value:" + cache.get("jerry"));
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception ex) {

            }
        }
    }
}
