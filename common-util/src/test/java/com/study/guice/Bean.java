package com.study.guice;

import javax.annotation.PostConstruct;

/**
 * Created by wangzhj on 2017/3/4.
 */
public class Bean {

    public Bean(){
        System.out.println("aaa");
    }

    @PostConstruct
    private void init(){
        System.out.println("bbb");
    }
}
