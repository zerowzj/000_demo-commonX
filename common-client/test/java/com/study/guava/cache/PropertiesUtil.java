package com.study.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2017/1/19.
 */
public class PropertiesUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public static final LoadingCache<String, Object> loadingCache = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build(new CacheLoader<String, Object>() {
                        @Override
                        public Object load(String key) throws Exception {
                            logger.info("CacheLoader.load");
                            Map<String, String> map = Maps.newHashMap();
                            map.put("1", "111");
                            map.put("2", "222");
                            map.put("3", "333");
                            return map.get(key);
                        }
                    }
            );


    public static String getString(String key){
        String str = null;
        try {
            str = loadingCache.get(key).toString();
        } catch (Exception ex){

        }
        return str;
    }
}
