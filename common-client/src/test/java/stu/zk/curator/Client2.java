package stu.zk.curator;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2017/2/24.
 */
public class Client2 {

    public static void main(String[] args)  throws Exception {
        Service2 serv = new Service2();
        serv.doJob("123");
        while (true){
            TimeUnit.SECONDS.sleep(100);
        }
    }
}
