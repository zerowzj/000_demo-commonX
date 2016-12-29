package com.company.util.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/28.
 *
 * 连接池中连接都是在发起请求的时候建立，并且都是长连接 HaoMaiClient.java中的in.close();作用就是将用完的连接释放，下次请求可以复用，
 * 这里特别注意的是，如果不使用in.close();而仅仅使用response.close();结果就是连接会被关闭，并且不能被复用，这样就失去了采用连接池的意义。
 * 连接池释放连接的时候，并不会直接对TCP连接的状态有任何改变，只是维护了两个Set，leased和avaliabled，leased代表被占用的连接集合，
 * avaliabled代表可用的连接的集合，释放连接的时候仅仅是将连接从leased中remove掉了，并把连接放到avaliabled集合中
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
            logger.info("release end connect count:=" + connManager.getTotalStats().getLeased());
            // Close expired connections
//            connManager.closeExpiredConnections();
            // Optionally, close connections
            // that have been idle longer than readTimeout*2 MILLISECONDS
//            connManager.closeIdleConnections(readTimeout * 2, TimeUnit.MILLISECONDS);
            logger.info("release end connect count:=" + connManager.getTotalStats().getAvailable());

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
