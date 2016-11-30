package com.study.guava.collections;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 18:22
 */
public class MapTest {

    @Test
    public void test(){
        Multimap<String, Object> map = ArrayListMultimap.create();
        // Adding some key/value
        map.put("Fruits", "Bannana");
        map.put("Fruits", "Apple");
        map.put("Fruits", "Pear");
        map.put("Fruits", "Pear");
        map.put("Vegetables", "Carrot");

        int size = map.size();
        System.out.println(size); // 5

        // Getting values
        Collection<Object> fruits = map.get("Fruits");
        System.out.println(fruits); //  [Bannana, Apple, Pear, Pear]
        // Set<Foo> set = Sets.newHashSet(list);
        // Set<Foo> foo = new HashSet<Foo>(myList);

        Collection<Object> vegetables = map.get("Vegetables");
        System.out.println(vegetables); // [Carrot]


        System.out.println(map.size());

    }
}
