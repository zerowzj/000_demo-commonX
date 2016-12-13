package com.study.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by wangzhj on 2016/12/8.
 */
public class JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisBaseTest.class);

    protected static JedisPool jedisPool = new JedisPool("localhost", 6379);
//    protected static JedisPool jedisPool = new JedisPool("172.18.4.178", 6380);

    protected Jedis jedis = null;

    @Before
    public void before() {
        jedis = jedisPool.getResource();
    }

    @After
    public void after() {
        jedis.close();
        jedisPool.destroy();
    }

    /**
     * ==============================
     * 存在
     * ==============================
     */
    @Test
    public void test_exists() {
        jedis = jedisPool.getResource();
        jedis.exists("");
    }

    /**
     * ==============================
     * 删除
     * ==============================
     */
    @Test
    public void test_del() {
        jedis = jedisPool.getResource();
        Long statusCode = jedis.del("");
    }

    /**
     * ==============================
     * 失效
     * ==============================
     */
    @Test
    public void test_expire() {
        jedis = jedisPool.getResource();
        jedis.expire("", 111);
    }
}
