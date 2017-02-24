package com.redis.jedis.pubsub;

import com.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisPublishTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisPublishTest.class);

    /**
     * 将信息 message 发送到指定的频道 channel 。
     *
     * @return Long 接收到信息 message 的订阅者数量。
     */
    @Test
    public void test_publish() {
        jedis = jedisPool.getResource();
        while (true) {
            String msg = "this is a message!";
            Long num = jedis.publish("channel", msg);
            logger.info("消息:{}, [{}]个订阅", msg, num);
            try {
                Thread.currentThread().sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
