package com.study.jedis.data;

import com.google.common.collect.Maps;
import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangzhj on 2016/12/8.
 */
public class JedisMapTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisMapTest.class);

    //==================== 放值 ====================
    @Test
    public void test_hset() {
        jedis = jedisPool.getResource();
        jedis.hset("hset", "name", "wangzhenjun");
        Long number = jedis.hset("hset", "age", "33");
        logger.info(number + "");
    }

    @Test
    public void test_hmset() {
        jedis = jedisPool.getResource();
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "wangzhj");
        map.put("age", "33");
        String str = jedis.hmset("user", map);
        logger.info(str);
    }

    //==================== 取值 ====================
    @Test
    public void test_hget() {
        jedis = jedisPool.getResource();
        String str = jedis.hget("hset", "name");
        logger.info(str);
    }

    @Test
    public void test_hmget() {
        jedis = jedisPool.getResource();
        List<String> valutLt = jedis.hmget("user", "name", "age");
        logger.info(valutLt + "");
    }

    @Test
    public void test_hgetAll() {
        jedis = jedisPool.getResource();
        Map<String, String> valutLt = jedis.hgetAll("user");
        logger.info(valutLt + "");
    }

    //==================== key和value ====================
    @Test
    public void test_hget1() {
        jedis = jedisPool.getResource();
        //key的个数
        Long length = jedis.hlen("user");
        logger.info(length + "");
        //key
        Set<String> keys = jedis.hkeys("user");
        logger.info(keys.toString());
        //value
        List<String> values = jedis.hvals("user");
        logger.info(values.toString());
    }

    /**
     * ==============================
     * 存在
     * ==============================
     */
    @Test
    public void test_hexists() {
        jedis = jedisPool.getResource();
        Boolean statusCode = jedis.hexists("user", "sss");
        logger.info(statusCode + "");
    }

    /**
     * ==============================
     * 删除
     * ==============================
     */
    @Test
    public void test_hdel() {
        jedis = jedisPool.getResource();
        Long statusCode = jedis.hdel("user", "sss");
        logger.info(statusCode + "");
    }
}
