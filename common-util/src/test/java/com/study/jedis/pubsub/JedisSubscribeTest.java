package com.study.jedis.pubsub;

import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisSubscribeTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisSubscribeTest.class);

    @Test
    public void test_subscribe() {
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                logger.info("=====>{}", message);
            }
        };
        //监听管道
        jedis.subscribe(jedisPubSub, "channel");
    }
}
