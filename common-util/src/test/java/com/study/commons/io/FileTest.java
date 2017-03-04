package com.study.commons.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhj on 2017/2/24.
 */
public class FileTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileTest.class);

    private static final String CACHE_FILE = "/usr/local/tomcat/logs/cache.list";

    @Test
    public void test_writeLines() {
        List<String> data = Arrays.asList("123", "abc", "ddd");
        try {
            FileUtils.writeLines(new File(CACHE_FILE), data, true);
        } catch (Exception ex) {
        }
    }

    @Test
    public void test_readLines() {
        try {
            List<String> data = FileUtils.readLines(new File(CACHE_FILE), Charset.forName("UTF-8"));
            LOGGER.info(data + "");
        } catch (Exception ex) {
        }
    }
}
