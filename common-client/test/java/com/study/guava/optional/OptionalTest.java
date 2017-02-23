package com.study.guava.optional;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by wangzhj on 2017/1/19.
 */
public class OptionalTest {

    @Test
    public void test(){
        List data = null;
        List lt = Optional.fromNullable(data).or(Collections.emptyList());
        System.out.println(lt);
    }
}
