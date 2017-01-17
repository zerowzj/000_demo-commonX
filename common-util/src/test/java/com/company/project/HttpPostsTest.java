package com.company.project;

import com.company.util.http.HttpGets;
import com.company.util.http.HttpPosts;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/29.
 */
public class HttpPostsTest {

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        int count = 5000;
        final Map<String, String> params = Maps.newHashMap();
        params.put("userName", "admin");
        params.put("token", "123");
        List<Thread> tLt = Lists.newArrayList();
        for(int i = 0; i < count; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpPosts.create("http://localhost:8080/demo/list", params)
                            .bodyFormat(HttpPosts.BodyFormat.JSON)
                            .submit();
                }
            });
            t.start();

            tLt.add(t);
        }
        for(Thread t : tLt){
            try {
                t.join();
            } catch (Exception ex) {

            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }


    @Test
    public void test_tt(){

        String str = "1a2s3dqwe";
        System.out.println(Base64.encodeBase64String(DigestUtils.md5(str)));

    }
}
