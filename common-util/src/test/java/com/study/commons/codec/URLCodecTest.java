package com.study.commons.codec;

import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2016/12/22.
 */
public class URLCodecTest {

    private static Logger logger = LoggerFactory.getLogger(URLCodecTest.class);

    @Test
    public void test() throws Exception {
        URLCodec urlCodec = new URLCodec();

        String str = "abc王昭君";

        String eStr = urlCodec.encode(str);
        logger.info(eStr);
        logger.info(urlCodec.decode(eStr));
        logger.info(urlCodec.getDefaultCharset());

    }
}
