package com.company.util.http;

import com.google.common.base.Joiner;
import com.google.common.io.ByteStreams;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public class HttpGetUtil {

    public static byte[] get(String url, Map<String, Object> params, Charset charset) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String queryStr = Joiner.on("&").withKeyValueSeparator("=").join(params);
        HttpGet httpGet = new HttpGet(url + "?" + queryStr);

        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] bytes = null;
        try {
            response = httpclient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if(statusCode == 200){
                is = response.getEntity().getContent();
                bytes = ByteStreams.toByteArray(is);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeQuietly(is);
            closeQuietly(response);
            closeQuietly(httpclient);
        }
        return bytes;
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
