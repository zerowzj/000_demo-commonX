package com.study.jedis.data;

import com.study.jedis.JedisBaseTest;
import com.study.jedis.MyObj;
import org.junit.Test;
import org.msgpack.MessagePack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by wangzhj on 2016/12/8.
 */
public class JedisStringTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisStringTest.class);

    /**
     * ==============================
     * 放值
     * ==============================
     */
    @Test
    public void test_set() {
        jedis = jedisPool.getResource();
        String statusCode = jedis.set("set", "123123123");
        logger.info(statusCode);
    }

    @Test
    public void test_mset() {
        jedis = jedisPool.getResource();
        String statusCode = jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
        logger.info(statusCode);
    }

    @Test
    public void test_setObj() {
        jedis = jedisPool.getResource();
        MessagePack pack = new MessagePack();
        //序列化
        MyObj obj = new MyObj();
        obj.setName("111");
        obj.setAge(100);
        try {
            byte[] key = "setObj".getBytes();
            byte[] bytes = pack.write(obj);
            String statusCode = jedis.set(key, bytes);
            logger.info(statusCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ==============================
     * 取值
     * ==============================
     */
    @Test
    public void test_get() {
        jedis = jedisPool.getResource();
        String str = jedis.get("set");
        logger.info(str);
    }

    @Test
    public void test_mget() {
        jedis = jedisPool.getResource();
        List<String> valueLt = jedis.mget("name", "age", "qq");
        logger.info(valueLt + "");
    }

    @Test
    public void test_getObj() {
        jedis = jedisPool.getResource();
        MessagePack pack = new MessagePack();
        try {
            byte[] key = "setObj".getBytes();
            byte[] bytes = jedis.get(key);
            MyObj obj = pack.read(bytes, MyObj.class);
            logger.info(obj.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ==============================
     * 计数
     * ==============================
     */
    @Test
    public void test_incr() {
        jedis = jedisPool.getResource();
        jedis.set("counter", "1.0");
        for (int i = 0; i < 5; i++) {
//            Long value = jedis.incr("counter");
            Double value = jedis.incrByFloat("counter", 1d);
            logger.info(value + "");
        }
    }

    @Test
    public void test_decr() {
        jedis = jedisPool.getResource();
        for (int i = 0; i < 5; i++) {
            Long value = jedis.decr("counter");
            logger.info(value + "");
        }
    }
}
