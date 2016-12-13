package com.study.jedis.pubsub;

import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisPublishTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisPublishTest.class);

    @Test
    public void test_publish() {
        jedis = jedisPool.getResource();
        while (true) {
            String msg = "this is a message!";
            jedis.publish("channel", msg);
            logger.info("发布:{}", msg);
            try {
                Thread.currentThread().sleep(3 * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
