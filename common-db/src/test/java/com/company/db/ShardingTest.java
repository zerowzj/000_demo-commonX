package com.company.db;


import com.company.db.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wangzhj
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-sharding.xml"})
public class ShardingTest {

    private static final Logger logger = LoggerFactory.getLogger(ShardingTest.class);

    @Autowired
    private OrderService orderService;

    @Test
    public void test_add() {
        String name = "我是写写库";
        orderService.add(1L, name);
    }
}
