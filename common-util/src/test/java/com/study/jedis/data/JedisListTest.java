package com.study.jedis.data;

import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.BinaryClient;

import java.util.List;

/**
 * Created by wangzhj on 2016/12/8.
 */
public class JedisListTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisListTest.class);

    /**
     * ==============================
     * 放值
     * ==============================
     */
    @Test
    public void test_lpush() {
        jedis = jedisPool.getResource();
        jedis.lpush("lpush", "VALUE_1");
        jedis.lpush("lpush", "VALUE_2");
        jedis.lpush("lpush", "VALUE_3");
    }

    @Test
    public void test_rpush() {
        jedis = jedisPool.getResource();
        Long number = jedis.rpush("rpush", "value3");
        logger.info(number + "");
    }

    @Test
    public void test_linsert() {
        jedis = jedisPool.getResource();
        Long str = jedis.linsert("key1", BinaryClient.LIST_POSITION.BEFORE, "100", "");
        logger.info(str + "");
    }

    /**
     * ==============================
     * 取值
     * ==============================
     */
    @Test
    public void test_lpop() {
        jedis = jedisPool.getResource();
        String value = jedis.lpop("lpush");
        logger.info(value);
    }

    @Test
    public void test_rpop() {
        jedis = jedisPool.getResource();
        String value = jedis.rpop("rpush");
        logger.info(value);
    }

    @Test
    public void test_lrang() {
        jedis = jedisPool.getResource();
        List<String> valueLt = jedis.lrange("lpush", 0, 2);
        logger.info(valueLt + "");
    }

    @Test
    public void test_lindex() {
        jedis = jedisPool.getResource();
        String value = jedis.lindex("lpush", 0);
        logger.info(value + "");
    }

    @Test
    public void test_ltrim() {
        jedis = jedisPool.getResource();
        String value = jedis.ltrim("lpush", 0, 2);
        logger.info(value + "");
    }

    /**
     * ==============================
     * <p/>
     * ==============================
     */
    @Test
    public void test_lset() {
        jedis = jedisPool.getResource();
        String str = jedis.lset("key1", 0, "");
        logger.info(str);
    }

    @Test
    public void test_trim() {
        jedis = jedisPool.getResource();
        logger.info(jedis.ltrim("key1", 0, 3));
    }

    @Test
    public void test() {
        jedis = jedisPool.getResource();
        //长度
        Long length = jedis.llen("");
        logger.info("" + length);
    }

    @Test
    public void test_sort() {
        jedis = jedisPool.getResource();
    }

    /**
     * ==============================
     * 队列和栈
     * ==============================
     */
    @Test
    public void test_stack() {
        jedis = jedisPool.getResource();
        String key = "";
        for (int i = 0; i < 5; i++) {
            String value = "VALUE_" + (i + 1);
            jedis.lpush(key, value);
            logger.info("===>{}", value);
        }
        String value = null;
        while ((value = jedis.lpop(key)) != null) {
            logger.info("<==={}", value);
        }
    }

    @Test
    public void test_queue() {
        jedis = jedisPool.getResource();
        String key = "";
        for (int i = 0; i < 5; i++) {
            String value = "VALUE_" + (i + 1);
            jedis.lpush(key, value);
            logger.info("===>{}", value);
        }
        String value = null;
        while ((value = jedis.rpop(key)) != null) {
            logger.info("<==={}", value);
        }
    }
}
