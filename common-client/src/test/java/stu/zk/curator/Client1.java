package stu.zk.curator;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2017/2/24.
 */
public class Client1 {

    public static void main(String[] args)  throws Exception {

        Service1 serv = new Service1();
        serv.doJob("123");

    }
}
