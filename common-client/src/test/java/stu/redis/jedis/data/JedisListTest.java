package stu.redis.jedis.data;

import stu.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.BinaryClient;

import java.util.List;

/**
 * 双向列表
 */
public class JedisListTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisListTest.class);

    //==============================
    //             放值
    //==============================

    /**
     * 将一个或多个值value插入到列表key的表头。
     * 如果有多个value值，那么各个value值按从左到右的顺序依次插入到表头：
     * 比如对一个空列表(mylist)执行LPUSH mylist a b c，则结果列表为c b a，等同于执行执行命令LPUSH mylist a、LPUSH mylist b、LPUSH mylist c。
     * 如果key不存在，一个空列表会被创建并执行LPUSH操作。
     * 当key存在但不是列表类型时，返回一个错误。
     *
     * @return Long 执行LPUSH命令后，列表的长度。
     */
    @Test
    public void test_lpush() {
        jedis = jedisPool.getResource();
        Long num1 = jedis.lpush("lpush", "VALUE_1");
        logger.info(num1 + "");
        Long num2 = jedis.lpush("lpush", "VALUE_2");
        logger.info(num2 + "");
        Long num3 = jedis.lpush("lpush", "VALUE_3");
        logger.info(num3 + "");
    }

    /**
     * 将值value插入到列表key的表头，当且仅当key存在并且是一个列表。
     * 和LPUSH命令相反，当key不存在时，LPUSHX命令什么也不做。
     *
     * @return Long LPUSHX命令执行之后，表的长度。
     */
    @Test
    public void test_lpushx() {
        jedis = jedisPool.getResource();
        Long str = jedis.lpushx("lpush11", "VALUE_1");
        logger.info(str + "");
    }

    /**
     * 将一个或多个值value插入到列表key的表尾。
     * 如果有多个value值，那么各个value值按从左到右的顺序依次插入到表尾：
     * 比如对一个空列表(mylist)执行RPUSH mylist a b c，则结果列表为a b c，等同于执行命令RPUSH mylist a、RPUSH mylist b、RPUSH mylist c。
     * 如果key不存在，一个空列表会被创建并执行RPUSH操作。
     * 当key存在但不是列表类型时，返回一个错误。
     *
     * @return Long 执行RPUSH操作后，表的长度。
     */
    @Test
    public void test_rpush() {
        jedis = jedisPool.getResource();
        Long number = jedis.rpush("rpush", "value3");
        logger.info(number + "");
    }

    /**
     * 将值value插入到列表key的表尾，当且仅当key存在并且是一个列表。
     * 和RPUSH命令相反，当key不存在时，RPUSHX命令什么也不做。
     *
     * @return Long RPUSHX命令执行之后，表的长度。
     */
    @Test
    public void test_rpushx() {
        jedis = jedisPool.getResource();
        Long number = jedis.rpushx("rpush", "value3");
        logger.info(number + "");
    }


    //==============================
    //           取值
    //==============================

    /**
     * 移除并返回列表key的头元素。
     *
     * @return 列表的头元素。当key不存在时，返回nil。
     */
    @Test
    public void test_lpop() {
        jedis = jedisPool.getResource();
        String value = jedis.lpop("lpush");
        logger.info(value);
    }

    @Test
    public void test_blpop() {
        jedis = jedisPool.getResource();
        List<String> value = jedis.blpop(100, "");
        logger.info(value + "");
    }

    /**
     * 移除并返回列表key的尾元素。
     *
     * @return 列表的尾元素。当key不存在时，返回nil。
     */
    @Test
    public void test_rpop() {
        jedis = jedisPool.getResource();
        String value = jedis.rpop("rpush");
        logger.info(value);
    }

    @Test
    public void test_brpop() {
        jedis = jedisPool.getResource();
        List<String> value = jedis.brpop(100, "");
        logger.info(value + "");
    }

    /**
     * 返回列表key中指定区间内的元素，区间以偏移量start和stop指定。
     * 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
     *
     * @return List 一个列表，包含指定区间内的元素。
     */
    @Test
    public void test_lrang() {
        jedis = jedisPool.getResource();
        List<String> valueLt = jedis.lrange("lpush", 0, 2);
        logger.info(valueLt + "");
    }

    /**
     * 返回列表key中，下标为index的元素。
     * 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
     * 如果key不是列表类型，返回一个错误
     *
     * @return 列表中下标为index的元素。如果index参数的值不在列表的区间范围内(out of range)，返回nil。
     */
    @Test
    public void test_lindex() {
        jedis = jedisPool.getResource();
        String value = jedis.lindex("lpush", 4);
        logger.info(value + "");
    }


    // ==============================
    //              改值
    // ==============================

    @Test
    public void test_linsert() {
        jedis = jedisPool.getResource();
        Long str = jedis.linsert("key1", BinaryClient.LIST_POSITION.BEFORE, "100", "");

        logger.info(str + "");
    }
    
    @Test
    public void test_lset() {
        jedis = jedisPool.getResource();
        String str = jedis.lset("lpush", 0, "tttttttttttttt");
        logger.info(str);
    }

    @Test
    public void test_trim() {
        jedis = jedisPool.getResource();
        logger.info(jedis.ltrim("key1", 0, 3));
    }

    /**
     * 返回列表key的长度。
     * 如果key不存在，则key被解释为一个空列表，返回0.
     * 如果key不是列表类型，返回一个错误。
     *
     * @return Long 列表key的长度。
     */
    @Test
    public void test_llen() {
        jedis = jedisPool.getResource();
        //长度
        Long length = jedis.llen("lpush");
        logger.info("" + length);
    }

    // ==============================
    //              改值
    // ==============================
    @Test
    public void test_sort() {
        jedis = jedisPool.getResource();
    }

    // ==============================
    //          队列和栈
    // ==============================
    @Test
    public void test_stack() {
        jedis = jedisPool.getResource();
        String key = "";
        for (int i = 0; i < 5; i++) {
            String value = "VALUE_" + (i + 1);
            jedis.lpush(key, value);
            logger.info("===>{}", value);
        }
        String value = null;
        while ((value = jedis.lpop(key)) != null) {
            logger.info("<==={}", value);
        }
    }

    @Test
    public void test_queue() {
        jedis = jedisPool.getResource();
        String key = "";
        for (int i = 0; i < 5; i++) {
            String value = "VALUE_" + (i + 1);
            jedis.lpush(key, value);
            logger.info("===>{}", value);
        }
        String value = null;
        while ((value = jedis.rpop(key)) != null) {
            logger.info("<==={}", value);
        }
    }
}
