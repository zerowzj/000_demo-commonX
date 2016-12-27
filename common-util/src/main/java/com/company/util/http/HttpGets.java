package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.Map;

/**
 * Http Get请求
 *
 * @author wangzhj
 */
public class HttpGets {

    private static final Logger logger = LoggerFactory.getLogger(HttpGets.class);

    private String url = null;
    private Map<String, String> params = null;

    private int connectTimeout = 30 * 1000;
    private int readTimeout = 60 * 1000;

    private HttpGets(String url, Map<String, String> params) {
        this.url = url;
        this.params = params;
    }

    public static HttpGets build(String url, Map<String, String> params) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is not null or empty");
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
     * 提交
     *
     * @return byte[]
     */
    public byte[] get() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] data = null;
        try {
            URI uri = new URIBuilder(url)
                    .setParameters(NVPairs.pairs(params))
                    .build();
            HttpGet httpGet = new HttpGet(uri);
            logger.info("url===> {}", httpGet.getURI().toString());

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout)
                    .setSocketTimeout(readTimeout)
                    .build();
            httpGet.setConfig(requestConfig);


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

    public static void main1(String[] args) {
        Map params = Maps.newTreeMap();
        params.put("userName", "admin");
        params.put("token", "123");
        byte[] data = HttpGets.build("http://localhost:8080/demo/list", params)
                .connectTimeout(1000).get();
        logger.info(new String(data));
    }

    public static void main(String[] args) {
        Map params = Maps.newTreeMap();
        params.put("idCard", "admin");
        params.put("captcha", "123");
        byte[] data = HttpGets.build("http://study.dongao.com/study/login/loginByShanXi", params)
                .connectTimeout(1000).get();
        logger.info(new String(data));

        logger.info(new Date().getTime() + "");
    }
}
