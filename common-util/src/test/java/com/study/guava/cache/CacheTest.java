package com.study.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by wangzhj on 2016/12/15.
 */
public class CacheTest {

    private static final Logger logger = LoggerFactory.getLogger(LoadingCacheTest.class);

    Cache<String, String> cache = CacheBuilder.newBuilder().build();

    public static void main(String[] args) throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
//        String resultVal = cache.get("jerry", new Callable<String>() {
//            public String call() {
//                String strProValue="hello "+"jerry"+"!";
//                return strProValue;
//            }
//        });
        String resultVal =    cache.getIfPresent("jerry");
        cache.put("", "");
        System.out.println("jerry value : " + resultVal);


        resultVal = cache.get("peida", new Callable<String>() {
            public String call() {
                String strProValue="hello "+"peida"+"!";
                return strProValue;
            }
        });
        System.out.println("peida value : " + resultVal);
    }
}
