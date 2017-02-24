package stu.redis.jedis;

import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * Created by wangzhj on 2016/12/8.
 */
@Message
public class MyObj implements Serializable {

    private String name = null;

    private int age = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
