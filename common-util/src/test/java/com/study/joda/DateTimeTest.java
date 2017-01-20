package com.study.joda;

import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by wangzhj on 2017/1/18.
 */
public class DateTimeTest {

    public static final Logger logger = LoggerFactory.getLogger(DateTimeTest.class);

    @Test
    public void test1() {
        DateTime dateTime = DateTime.now();

        logger.info(dateTime.toString("yyyy-MM-dd HH:mm:ss.sss"));
        logger.info(dateTime.toString("yyy年MM月dd日 HH:mm:ss EE"));
        logger.info("{}", dateTime.monthOfYear().getAsString());
        logger.info("{}", dateTime.getDayOfMonth());
        logger.info("{}", dateTime.getDayOfWeek());
        logger.info("{}", dateTime.getHourOfDay());
        logger.info("{}", dateTime.getMinuteOfHour());
    }


    @Test
    public void test2() {
        //
        DateTime dateTime = new DateTime(new Date());
        //
        Date date = dateTime.toDate();
    }
}
