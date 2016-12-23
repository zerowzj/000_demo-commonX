package com.company.util.http;

import com.google.common.base.Joiner;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public class HttpPostUtil {

    public void postJson(String url){

    }

    public void postForm(String url){

    }
    private void post(String url, Map<String, String> params, String charset) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {

        } catch (Exception ex){

        } finally {

        }
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
