package com.study.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by wangzhj on 2017/3/4.
 */
public class Min {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new Object() {
            @Subscribe
            public void lister(String str) {
                System.out.println("0000000000000==="+str);
            }
        });
        eventBus.register(new Object() {
            @Subscribe
            public void lister(String str) {
                System.out.println("111111111==="+str);
            }
        });

        eventBus.post("ssssssssss");
    }
}
