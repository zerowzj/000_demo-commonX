package stu.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CreateBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2017/2/24.
 */
public class Service1 {
    static String servers = "127.0.0.1:2181";
    static CuratorFramework client = CuratorFrameworkFactory.builder().retryPolicy(new ExponentialBackoffRetry(10000, 3)).connectString(servers).build();

    static {
        client.start();
    }

    public void doJob(String value) {
        String nodeName = "/temp"+"/"+value;
        try {
            Stat stat = client.checkExists().forPath(nodeName);
            if (stat != null) {
                System.out.println("value="+value+"正在执行！！！");
                return;
            }
            CreateBuilder createBuilder = client.create();
            String opResult = createBuilder.creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(nodeName, "123".getBytes("UTF-8"));

            while (true){
                TimeUnit.SECONDS.sleep(100);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            client.close();
        }
    }

}
