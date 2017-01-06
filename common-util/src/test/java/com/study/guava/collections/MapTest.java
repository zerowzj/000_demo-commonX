package com.study.guava.collections;

import com.company.util.JsonUtil;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 18:22
 */
public class MapTest {

    private static final Logger logger = LoggerFactory.getLogger(MapTest.class);

    @Test
    public void test_ListMultimap(){
        ListMultimap<String, Object> map = ArrayListMultimap.create();
        map.put("Fruits", "Bannana");
        map.put("Fruits", "Apple");
        map.put("Fruits", "Pear");
        map.put("Fruits", "Pear");

        Collection<Object> fruits = map.get("Fruits");
        logger.info(fruits.toString());
    }

    @Test
    public void test_SetMultimap(){
        SetMultimap map = HashMultimap.create();
        map.put("Fruits", "Bannana");
        map.put("Fruits", "Apple");
        map.put("Fruits", "Pear");
        map.put("Fruits", "Pear");

        Collection<Long> fruits = map.get("Fruits");
        logger.info(fruits.toString());
    }

    @Test
    public void test(){
        List<ClassVO> classVOLt = Lists.newArrayList();
        classVOLt.add(new ClassVO("1", "abc"));
        classVOLt.add(new ClassVO("2", "efg"));

        List<Map<String, String>> dataLt = Lists.newArrayList();
        Map<String, String> data = null;
        for(ClassVO classVO : classVOLt){
            data = Maps.newHashMap();

            data.put("id", classVO.getId());
            data.put("name", classVO.getName());

            dataLt.add(data);
        }

        logger.info(JsonUtil.toJson(dataLt));

    }
}
