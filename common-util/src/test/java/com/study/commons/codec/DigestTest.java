package com.study.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/22.
 */
public class DigestTest {

    private static Logger logger = LoggerFactory.getLogger(DigestTest.class);

    @Test
    public void test_md5(){
        String str = "123456";
        logger.info(DigestUtils.md5Hex(str));
    }
}
