package com.company.util.http;

import com.google.common.base.Joiner;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public class HttpPostUtil {

    private void get(String url, Map<String, Object> params) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String queryStr = Joiner.on("&").withKeyValueSeparator("=").join(params);
        HttpGet httpGet = new HttpGet(url + "?" + queryStr);

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            response.getStatusLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeQuietly(response);
            closeQuietly(httpclient);
        }
    }

    private void post(String url) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
    }


    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
