package com.company.db;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangzhj on 2016/12/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:*.xml"})
public class JUnitBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JUnitBaseTest.class);

    @Before
    public void before(){
        logger.info("**********执行前**********");
        logger.info("");
    }

    @After
    public void after(){
        logger.info("");
        logger.info("**********执行后**********");
    }
}
