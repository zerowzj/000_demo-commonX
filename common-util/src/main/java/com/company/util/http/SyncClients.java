package com.company.util.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/29.
 */
public class SyncClients {

    private static final Logger logger = LoggerFactory.getLogger(AsyncClients.class);

    private static PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

    static {
        //连接池最大生成连接数200
        connManager.setMaxTotal(1000);
        logger.info("sssssssssssssssssssssssss");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new IdleMonitor(), 1000, 5000, TimeUnit.MILLISECONDS);

    }

    private static class IdleMonitor implements Runnable {

        @Override
        public void run() {
            logger.info("监控");
            logger.info("release end connect count:=" + connManager.getTotalStats().getLeased());
            logger.info("release end connect count:=" + connManager.getTotalStats().getMax());
            logger.info("release end connect count:=" + connManager.getTotalStats().getPending());
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
}
