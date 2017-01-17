package com.study.jdk.reg;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by wangzhj on 2017/1/16.
 */
public class RegTtest {

    List<String> whiteList = Arrays.asList("/reg/auto_login", "/wizard?system_id=");

    private boolean checkIsInWhiteList(String url) {
        if (!url.endsWith("/")) {
            url = url + "/";
        }
        for (String tmp : whiteList) {
            if (!tmp.endsWith("/")) {
                tmp = tmp + "/";
            }

            if (tmp.equals(url)) {
                return true;
            }

            if (tmp.contains("\\d") || tmp.contains("\\w")) {
                boolean flag = Pattern.compile(tmp).matcher(url).find();
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    public void test(){
        String url = "/wizard";
        System.out.println(checkIsInWhiteList(url));
    }
}
