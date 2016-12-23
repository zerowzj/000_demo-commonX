package com.study.commons;

import com.company.util.JsonUtil;
import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/22.
 */
public class ESTest {

    @Test
    public void test_client() throws Exception{
        Map<String, Object> data = Maps.newHashMap();
        data.put("id", "123456");
        data.put("name", "姓名");
        Client client = TransportClient.builder().build()
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9200)));
        IndexResponse response = client.prepareIndex("twitter", "tweet")
                .setSource(JsonUtil.toJson(data))
                .get();
    }

    @Test
    public void test(){

        String str = "success\n\t\r";

        System.out.println("["+str+"]");
        System.out.println("[" + CharMatcher.javaIsoControl().removeFrom(str)+ "]");

    }
}
