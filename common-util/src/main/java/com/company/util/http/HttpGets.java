package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/**
 * Http Get请求
 *
 * @author wangzhj
 */
public class HttpGets extends Https {

    private static final Logger logger = LoggerFactory.getLogger(HttpGets.class);

    private HttpGets(String url, Map<String, String> params) {
        super(url, params);
    }

    public static HttpGets create(String url) {
        return create(url, null);
    }

    public static HttpGets create(String url, Map<String, String> params) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is not null or empty");
        return new HttpGets(url, params);
    }

    @Override
    public byte[] submit() {
        CloseableHttpClient httpClient = CloseableHttpClients.createHttpClient();
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] data = null;
        try {
            //Url
            URIBuilder builder = new URIBuilder(url);
            if(paramMap != null && !paramMap.isEmpty()){
                builder.setParameters(NVPairs.pairs(paramMap));
            }
            URI uri = builder.build();
            //Get
            httpGet = new HttpGet(uri);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout)
                    .setSocketTimeout(readTimeout)
                    .build();
            httpGet.setConfig(requestConfig);
            //头部
            if(headerMap != null && !headerMap.isEmpty()){
                httpGet.setHeaders(Headers.create(headerMap));
            }
            logger.info("url===> {}", httpGet.getURI().toString());
            //请求
            response = httpClient.execute(httpGet);
            //响应
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
            releaseConnection(httpGet);
            CloseUtil.closeQuietly(httpClient);
        }
        return data;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpGets.create("http://www.baidu.com").submit();
                }
            });
            t.start();
        }
    }
}
