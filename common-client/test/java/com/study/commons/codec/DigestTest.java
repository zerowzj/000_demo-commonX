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
//        String str = "hs=1482677302218&InnerTime=240&PlayTime=2271&selectparam=16jxjy-dwl-zzjd-600_2016&VideoID=0103";
        String str = "selectparam=16jxjy-dwl-zzjd-600_2016&VideoID=0103&PlayTime=2271&InnerTime=240&hs=1482677302218";
        logger.info(DigestUtils.md5Hex(str));
        logger.info("8fc32e87935f87891e65a47d11bab847");
    }
}
