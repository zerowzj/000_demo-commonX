package com.company.util.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.nio.conn.NHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/28.
 */
class CloseableHttpClients {

    private static final Logger logger = LoggerFactory.getLogger(CloseableHttpClients.class);

    private static PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

//    private static NHttpClientConnectionManager asyncConnManager = new PoolingNHttpClientConnectionManager();

    static {
        //连接池最大生成连接数200
        connManager.setMaxTotal(10);
        logger.info("sssssssssssssssssssssssss");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new IdleMonitor(), 1000, 5000, TimeUnit.MILLISECONDS);

    }

    private static class IdleMonitor implements Runnable {

        @Override
        public void run() {
            logger.info("监控");

            // Close expired connections
//            connManager.closeExpiredConnections();
            // Optionally, close connections
            // that have been idle longer than readTimeout*2 MILLISECONDS
//            connManager.closeIdleConnections(readTimeout * 2, TimeUnit.MILLISECONDS);
//            logger.info("release end connect count:=" + connManager.getTotalStats().getAvailable());

        }
    }

    /**
     * 创建HttpClient
     *
     * @return CloseableHttpClient
     */
    public static CloseableHttpClient createHttpClient() {
        return HttpClients.createDefault();
    }

    /**
     * 获取HttpClient
     *
     * @return CloseableHttpClient
     */
    public static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();
        return httpClient;
    }

    /**
     * 创建异步HttpClient
     *
     * @return CloseableHttpAsyncClient
     */
    public static CloseableHttpAsyncClient createHttpAsyncClient() {
        return HttpAsyncClients.createDefault();
    }

    /**
     * 获取异步HttpClient
     *
     * @return CloseableHttpAsyncClient
     */
//    public static CloseableHttpAsyncClient getHttpAsyncClient() {
//        CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
//                .setConnectionManager(asyncConnManager)
//                .build();
//        return httpClient;
//    }
}