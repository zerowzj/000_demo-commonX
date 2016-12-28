package com.company.util.http;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhj on 2016/12/28.
 */
public class ConnManager {

    private static final Logger logger = LoggerFactory.getLogger(ConnManager.class);

    protected static PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

    static {
        //连接池最大生成连接数200
        connManager.setMaxTotal(100);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(new IdleConnectionMonitor(connManager), initialDelay, heartbeatPeriod, unit);

    }

    private static class IdleConnectionMonitor implements Runnable {
        PoolingHttpClientConnectionManager connManager;

        public IdleConnectionMonitor(PoolingHttpClientConnectionManager connectionManager) {
            this.connManager = connectionManager;
        }

        @Override
        public void run() {

//            // Close expired connections
//            connManager.closeExpiredConnections();
//            // Optionally, close connections
//            // that have been idle longer than readTimeout*2 MILLISECONDS
//            connManager.closeIdleConnections(readTimeout * 2, TimeUnit.MILLISECONDS);
//            logger.info("release end connect count:=" + connManager.getTotalStats().getAvailable());

        }
    }
}
