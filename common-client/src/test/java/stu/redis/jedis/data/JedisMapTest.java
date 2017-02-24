package stu.redis.jedis.data;

import com.google.common.collect.Maps;
import stu.redis.jedis.JedisBaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 散列
 */
public class JedisMapTest extends JedisBaseTest {

    private static final Logger logger = LoggerFactory.getLogger(JedisMapTest.class);

    //==============================
    //             放值
    //==============================

    /**
     * 将哈希表key中的域field的值设为value。
     * 如果key不存在，一个新的哈希表被创建并进行HSET操作。
     * 如果域field已经存在于哈希表中，旧值将被覆盖。
     *
     * @return Long 如果field是哈希表中的一个新建域，并且值设置成功，返回1。
     * 如果哈希表中域field已经存在且旧值已被新值覆盖，返回0。
     */
    @Test
    public void test_hset() {
        jedis = jedisPool.getResource();
        jedis.hset("hset", "name", "wangzhenjun");
        Long number = jedis.hset("hset", "age", "33");
        logger.info(number + "");
    }

    /**
     * 将哈希表key中的域field的值设置为value，当且仅当域field不存在。
     * 若域field已经存在，该操作无效。
     * 如果key不存在，一个新哈希表被创建并执行HSETNX命令。
     *
     * @return Long 设置成功，返回1。如果给定域已经存在且没有操作被执行，返回0。
     */
    @Test
    public void test_hsetnx() {
        jedis = jedisPool.getResource();
        jedis.hset("hset", "name", "wangzhenjun");
        Long number = jedis.hsetnx("hset", "age", "33");
        logger.info(number + "");
    }

    /**
     * 同时将多个field - value(域-值)对设置到哈希表key中。
     * 此命令会覆盖哈希表中已存在的域。
     * 如果key不存在，一个空哈希表被创建并执行HMSET操作。
     *
     * @return String 如果命令执行成功，返回OK。当key不是哈希表(hash)类型时，返回一个错误。
     */
    @Test
    public void test_hmset() {
        jedis = jedisPool.getResource();
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "wangzhj");
        map.put("age", "33");
        String str = jedis.hmset("user", map);
        logger.info(str);
    }

    //==============================
    //             取值
    //==============================

    /**
     * 返回哈希表key中给定域field的值。
     *
     * @return String 给定域的值。当给定域不存在或是给定key不存在时，返回nil。
     */
    @Test
    public void test_hget() {
        jedis = jedisPool.getResource();
        String str = jedis.hget("hset", "name");
        logger.info(str);
    }

    /**
     * 返回哈希表key中，一个或多个给定域的值。
     * 如果给定的域不存在于哈希表，那么返回一个nil值。
     * 因为不存在的key被当作一个空哈希表来处理，所以对一个不存在的key进行HMGET操作将返回一个只带有nil值的表。
     *
     * @return List 一个包含多个给定域的关联值的表，表值的排列顺序和给定域参数的请求顺序一样。
     */
    @Test
    public void test_hmget() {
        jedis = jedisPool.getResource();
        List<String> valutLt = jedis.hmget("user", "name", "age");
        logger.info(valutLt + "");
    }

    /**
     * 返回哈希表key中，所有的域和值。
     * 在返回值里，紧跟每个域名(field name)之后是域的值(value)，所以返回值的长度是哈希表大小的两倍。
     *
     * @return Lit 以列表形式返回哈希表的域和域的值。 若key不存在，返回空列表。
     */
    @Test
    public void test_hgetAll() {
        jedis = jedisPool.getResource();
        Map<String, String> valutLt = jedis.hgetAll("user");
        logger.info(valutLt + "");
    }

    /**
     * 返回哈希表key中的所有域。
     *
     * @return Set 一个包含哈希表中所有域的表。当key不存在时，返回一个空表。
     */
    @Test
    public void test_hkeys() {
        jedis = jedisPool.getResource();
        Set<String> valutLt = jedis.hkeys("user");
        logger.info(valutLt + "");
    }

    /**
     * 返回哈希表key中的所有值。
     *
     * @return List 一个包含哈希表中所有值的表。当key不存在时，返回一个空表。
     */
    @Test
    public void test_hvals() {
        jedis = jedisPool.getResource();
        List<String> valutLt = jedis.hvals("user");
        logger.info(valutLt + "");
    }

    //==============================
    //             删除
    //==============================

    /**
     * 删除哈希表key中的一个或多个指定域，不存在的域将被忽略。
     *
     * @return 被成功移除的域的数量，不包括被忽略的域。
     */
    @Test
    public void test_hdel() {
        jedis = jedisPool.getResource();
        Long statusCode = jedis.hdel("user", "sss");
        logger.info(statusCode + "");
    }

    //==============================
    //             存在
    //==============================

    /**
     * 查看哈希表key中，给定域field是否存在。
     *
     * @return 如果哈希表含有给定域，返回1。如果哈希表不含有给定域，或key不存在，返回0。
     */
    @Test
    public void test_hexists() {
        jedis = jedisPool.getResource();
        Boolean statusCode = jedis.hexists("user", "sss");
        logger.info(statusCode + "");
    }

    //==============================
    //             域数量
    //==============================

    /**
     * 返回哈希表key中域的数量。
     *
     * @return 哈希表中域的数量。当key不存在时，返回0。
     */
    @Test
    public void test_hlen() {
        jedis = jedisPool.getResource();
        Long count = jedis.hlen("user");
        logger.info(count + "");
    }

}
