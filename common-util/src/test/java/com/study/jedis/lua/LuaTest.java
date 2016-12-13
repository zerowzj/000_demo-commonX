package com.study.jedis.lua;

import com.google.common.io.CharStreams;
import com.study.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class LuaTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(LuaTest.class);

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        try {
            FileInputStream fi = new FileInputStream("D:\\project\\my\\common\\common-util\\src\\test\\java\\com\\study\\jedis\\lua\\script.lua");
            Reader reader = new InputStreamReader(fi);
            String str = CharStreams.toString(reader);
            jedis.eval(str);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("耗时 {}", System.currentTimeMillis() - start);
        }
    }
}
