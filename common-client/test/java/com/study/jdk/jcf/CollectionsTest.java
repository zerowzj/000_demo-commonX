package com.study.jdk.jcf;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wangzhj on 2017/2/21.
 */
public class CollectionsTest {

    @Test
    public void test() {
        final List<Long> data = Lists.newArrayList(1L, 3L, 2L, 6L, 4L);

        Collections.sort(data, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 >= o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(data);


        Collections.sort(data, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 >= o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(data);
    }
}
