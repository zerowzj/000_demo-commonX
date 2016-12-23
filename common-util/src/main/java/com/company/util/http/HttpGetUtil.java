package com.company.util.http;

import com.company.util.Closeables;
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

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public abstract class HttpGetUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpGetUtil.class);

    public static String getString(String url, Map<String, String> params, Charset charset) {
        byte[] result = get(url, params);

        return null;
    }

    public static byte[] get(String url, Map<String, String> params) {
        String query = Joiner.on("&").withKeyValueSeparator("=").join(params);
        logger.info("url===> {}", url);
        logger.info("query===> {}", query);
        HttpGet httpGet = new HttpGet(url + "?" + query);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] result = null;
        try {
            response = httpClient.execute(httpGet);

            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            logger.info("status code===> {}", statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                is = response.getEntity().getContent();
                result = ByteStreams.toByteArray(is);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Closeables.closeQuietly(is);
            Closeables.closeQuietly(response);
            Closeables.closeQuietly(httpClient);
        }
        return result;
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
