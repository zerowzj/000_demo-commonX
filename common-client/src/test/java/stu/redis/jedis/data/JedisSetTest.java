package stu.redis.jedis.data;

import stu.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/8.
 */
public class JedisSetTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisSetTest.class);

    //==============================
    //             放值
    //==============================
    /**
     *
     *
     */
    @Test
    public void test_sadd() {
        jedis = jedisPool.getResource();
        Long num1 = jedis.sadd("set", "a");
        logger.info(num1 + "");
        Long num2 = jedis.sadd("set", "b");
        logger.info(num2 + "");
    }

    /**
     * ==============================
     * 取值
     * ==============================
     */
    @Test
    public void test_lpop() {
        jedis = jedisPool.getResource();
    }
}
