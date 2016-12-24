package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public class HttpGets {

    private static final Logger logger = LoggerFactory.getLogger(HttpGets.class);

    /** URL */
    private String url = null;
    /**  参数 */
    private Map<String, String> params = null;

    /** 连接超时时间 */
    private int connectTimeout = 0;
    /** 读取超时时间 */
    private int readTimeout = 0;

    private HttpGets(String url, Map<String, String> params) {
        Preconditions.checkNotNull(Strings.emptyToNull(url), "url is not null");
        this.url = url;
        this.params = params;
    }

    public static HttpGets build(String url, Map<String, String> params) {
        return new HttpGets(url, params);
    }

    public HttpGets connectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public HttpGets readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    /**
     * 获取
     *
     * @return String
     */
    public String getString() {
        byte[] data = get();
        return new String(data);
    }

    /**
     * 获取
     *
     * @return byte[]
     */
    public byte[] get() {
        String query = Joiner.on("&").withKeyValueSeparator("=").join(params);
        logger.info("url===> {}", url);
        logger.info("query===> {}", query);
        HttpGet httpGet = new HttpGet(url + "?" + query);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(readTimeout)
                .build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] data = null;
        try {
            response = httpClient.execute(httpGet);

            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            logger.info("status code===> {}", statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                is = response.getEntity().getContent();
                data = ByteStreams.toByteArray(is);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            CloseUtil.closeQuietly(is);
            CloseUtil.closeQuietly(response);
            CloseUtil.closeQuietly(httpClient);
        }
        return data;
    }

    public static void main(String[] args) {
        Map params = Maps.newTreeMap();
        params.put("key1", "value1");
        params.put("key2", "value1");
        params.put("key3", "value1");
        params.put("key4", "value1");
        params.put("key5", "value1");
        params.put("key6", "value1");
        params.put("key7", "value1");
        params.put("key8", "value1");
        params.put("key9", "value1");
        HttpGets.build("2121", params).getString();
    }
}
