package com.study.jedis.lua;

import com.google.common.io.CharStreams;
import com.study.jedis.JedisBaseTest;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created by wangzhj on 2016/12/13.
 */
public class LuaTest extends JedisBaseTest {

    @Test
    public void test(){
        try {
            FileInputStream fi = new FileInputStream("D:\\project\\my\\common\\common-util\\src\\test\\java\\com\\study\\jedis\\lua\\script.lua");
            Reader reader = new InputStreamReader(fi);
            String str = CharStreams.toString(reader);
            jedis.eval(str, Arrays.asList("key1","key2"), Arrays.asList("arg1","arg2"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


//    private String loadScript(String fileName) throws IOException {
//         return CharStreams.toString(reader);
//    }
}
