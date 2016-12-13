package com.study.jedis.pipeline;

import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class JedisPipelineTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisPipelineTest.class);

    private static final int count = 1000;

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        not_pipeline();
        long end = System.currentTimeMillis();
        logger.info("not_pipeline: " + (end - start));
        start = System.currentTimeMillis();
        use_pipeline();
        end = System.currentTimeMillis();
        logger.info("use_pipeline: " + (end - start));
    }


    private void not_pipeline() {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        try {
            for (int i = 0; i < count; i++) {
                jedis.incr("");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedis.close();
            jedisPool.close();
        }
    }

    private void use_pipeline() {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        try {
            Pipeline pipeline = jedis.pipelined();
            for (int i = 0; i < count; i++) {
                pipeline.incr("");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jedis.close();
            jedisPool.close();
        }
    }
}
