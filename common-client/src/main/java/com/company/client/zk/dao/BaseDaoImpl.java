package com.company.client.zk.dao;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 基础Dao实现
 *
 * CuratorFrameworkFactory是线程安全的。
 * 你应该在应用中为单一的ZooKeeper集群共享唯一的CuratorFramework实例。
 * 工厂方法(newClient())提供了一个简单的方式创建实例。Builder可以使用更多的参数控制生成的实例。
 * 一旦生成framework实例， 必须调用start方法启动它。应用结束时应该调用close方法关闭它。
 *
 * @author wangzhj
 */
@Scope("prototype")
abstract class BaseDaoImpl {

    private String zkAddress;

    private CuratorFramework client;

    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct......");
        client = CuratorFrameworkFactory.newClient(zkAddress, new ExponentialBackoffRetry(1000, 3));
        client.start();
    }

    @PreDestroy
    private void destroy() {
        System.out.println("@PreDestroy......");
        if (client != null) {
            client.close();
        }
    }

    public CuratorFramework getClient() {
        return client;
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }
}
