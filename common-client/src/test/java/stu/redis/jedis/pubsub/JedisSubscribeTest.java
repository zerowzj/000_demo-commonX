package stu.redis.jedis.pubsub;

import stu.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisSubscribeTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisSubscribeTest.class);

    /**
     * 订阅给定频道的信息。
     *
     */
    @Test
    public void test_subscribe() {
        //监听
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                logger.info("=====>{}", message);
            }
        };
        //订阅
        jedis.subscribe(jedisPubSub, "channel");
    }
}
