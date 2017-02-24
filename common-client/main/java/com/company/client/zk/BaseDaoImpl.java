package com.company.client.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 基础Dao实现
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
