package com.study.jedis.trans;

import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Transaction;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisTransTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisTransTest.class);

    @Test
    public void test_no_trans() {
        jedis = jedisPool.getResource();
        jedis.set("step1", "value11111");
        String str = null;
        str.equals("");
        jedis.set("step2", "value22222");
    }

    @Test
    public void test_trans() {
        jedis = jedisPool.getResource();
        Transaction multi = jedis.multi();
        multi.set("step1", "value11111");
        String str = null;
        str.equals("");
        multi.set("step2", "value22222");
        multi.exec();
    }
}
