package com.study.jedis.trans;

import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisTransTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisTransTest.class);

    @Test
    public void test_trans() {
        jedis = jedisPool.getResource();
    }
}
