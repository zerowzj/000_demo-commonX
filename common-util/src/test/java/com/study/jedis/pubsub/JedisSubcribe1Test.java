package com.study.jedis.pubsub;

import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisSubcribe1Test extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisSubcribe1Test.class);

    @Test
    public void test_subcribe() {
        //监听管道
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                logger.info("=====>{}", message);
            }
        }, "channel");
    }
}
