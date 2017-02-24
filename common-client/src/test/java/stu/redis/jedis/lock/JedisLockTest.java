package stu.redis.jedis.lock;

import stu.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisLockTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisLockTest.class);

    @Test
    public void test_trans() {
        jedis = jedisPool.getResource();
    }
}
