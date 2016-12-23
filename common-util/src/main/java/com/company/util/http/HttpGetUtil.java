package com.company.util.http;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public abstract class HttpGetUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpGetUtil.class);

    public static String getStr(String url, Map<String, String> params, Charset charset){
        byte[] result = get(url, params);

        return null;
    }

    public static byte[] get(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String queryStr = Joiner.on("&").withKeyValueSeparator("=").join(params);
        HttpGet httpGet = new HttpGet(url + "?" + queryStr);
        logger.info("url===> {}", url);
        logger.info("query string===> {}", queryStr);

        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] bytes = null;
        try {
            response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            logger.warn("status code===> {}", statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                is = response.getEntity().getContent();
                bytes = ByteStreams.toByteArray(is);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeQuietly(is);
            closeQuietly(response);
            closeQuietly(httpClient);
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

    public static void main(String[] args) {
        Map params = Maps.newTreeMap();
        params.put("key1", "valu1");
        params.put("key2", "asdf");
        params.put("key3", "asdf");
        params.put("key4", "asdf");
        params.put("key5", "asdf");
        params.put("key6", "asdf");
        params.put("key7", "asdf");
        params.put("key8", "asdf");
        params.put("key9", "asdf");
        get("http://www.sohu.com", params);
    }
}
