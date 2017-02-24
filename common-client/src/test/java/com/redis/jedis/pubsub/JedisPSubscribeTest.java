package com.redis.jedis.pubsub;

import com.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisPSubscribeTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisPSubscribeTest.class);

    /**
     * 订阅符合给定模式的频道。
     * 每个模式以 * 作为匹配符，比如 huangz* 匹配所有以 huangz 开头的频道( huangzmsg 、 huangz-blog 、 huangz.tweets 等等)，
     * news.* 匹配所有以 news. 开头的频道( news.it 、 news.global.today 等等)，诸如此类。
     */
    @Test
    public void test_psubscribe() {
        //监听
        JedisPubSub jedisPubSub = new JedisPubSub() {

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                logger.info("[{}]******>{}", pattern, message);
            }
        };
        //订阅
        jedis.psubscribe(jedisPubSub, "channel*");
    }
}
