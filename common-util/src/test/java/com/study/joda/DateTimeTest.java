package com.study.joda;

import com.google.common.base.Splitter;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by wangzhj on 2017/1/18.
 */
public class DateTimeTest {

    public static final Logger logger = LoggerFactory.getLogger(DateTimeTest.class);

    @Test
    public void test() {
        DateTime dateTime = DateTime.now();
        logger.info("{}", dateTime.monthOfYear().getAsString());
        logger.info("{}", dateTime.getDayOfMonth());
        logger.info("{}", dateTime.getDayOfWeek());
        logger.info("{}", dateTime.getHourOfDay());
        logger.info("{}", dateTime.getMinuteOfHour());

        Date date = dateTime.toDate();
    }
}
