package com.study.joda;

import com.google.common.base.Splitter;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.TimeOfDay;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangzhj on 2017/1/18.
 */
public class LocalTimeTest {

    private static final Logger logger = LoggerFactory.getLogger(LocalTimeTest.class);

    @Test
    public void test() {
        LocalTime nowTime = LocalTime.now();
        logger.info("{}", nowTime.getHourOfDay());
        logger.info("{}", nowTime.getMinuteOfHour());
//        logger.info("{}", nowTime.secondOfMinute().get);
    }

    @Test
    public void test_test(){
//      String str = "18:00-23:59|00:00-07:00";
        String str = "10-15:53";
        LocalTime nowTime = LocalTime.now();
        LocalTime myTime = new LocalTime(10, 23);
        logger.info("===={}", myTime.toString(DateTimeFormat.shortDate()));
        Iterator<String> it = Splitter.on('|').split(str).iterator();
        while(it.hasNext()){
            List<String> hm = Splitter.on('-').splitToList(it.next());
            LocalTime startTime = new LocalTime(hm.get(0));
            LocalTime endTime = new LocalTime(hm.get(1));
            logger.info("start_time==>{}", startTime.toString());
            logger.info("end_time==>{}", endTime.toString());
            logger.info("now_time==>{}", nowTime.toString());
            logger.info("===>{}",nowTime.isAfter(startTime) && nowTime.isBefore(endTime));
        }
    }
}
