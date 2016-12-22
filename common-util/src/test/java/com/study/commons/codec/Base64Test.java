package com.study.commons.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/22.
 */
public class Base64Test {

    private static Logger logger = LoggerFactory.getLogger(Base64Test.class);

    @Test
    public void test_md5(){
        String str = "你好1a";

        logger.info(Base64.encodeBase64String(str.getBytes()));

    }

    @Test
    public void test_isBase64(){
        String str = "la";
        logger.info(Base64.isBase64(str)+"");
    }
}
