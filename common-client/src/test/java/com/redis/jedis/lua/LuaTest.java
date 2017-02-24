package com.redis.jedis.lua;

import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class LuaTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LuaTest.class);

    @Test
    public void test_user_login() {
        try {
            File file = new File("D:\\project\\my\\common\\common-util\\src\\test\\java\\com\\study\\jedis\\lua\\user_login.lua");
            Reader reader = Files.newReader(file, Charset.forName("UTF-8"));
            String str = CharStreams.toString(reader);
            Object obj = jedis.eval(str, Arrays.asList("1111"), Arrays.asList(""));
            logger.info(obj.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test_get() {
        try {
            File file = new File("D:\\project\\my\\common\\common-util\\src\\test\\java\\com\\study\\jedis\\lua\\get.lua");
            Reader reader = Files.newReader(file, Charset.forName("UTF-8"));
            String str = CharStreams.toString(reader);
            Object obj = jedis.eval(str);
            logger.info(obj.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        try {
            File file = new File("D:\\project\\my\\common\\common-util\\src\\test\\java\\com\\study\\jedis\\lua\\incr.lua");
            Reader reader = Files.newReader(file, Charset.forName("UTF-8"));
            String str = CharStreams.toString(reader);
            jedis.eval(str);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("耗时 {}", System.currentTimeMillis() - start);
        }
    }
}
