package com.study.guava.collections;

/**
 * Created by wangzhj on 2017/1/6.
 */
public class ClassVO {

    private String id;

    private String name;

    public ClassVO(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
