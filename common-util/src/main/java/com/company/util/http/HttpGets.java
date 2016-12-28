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
import org.apache.http.impl.client.HttpClients;
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
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connManager)
                .build();
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] data = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            if(params != null && !params.isEmpty()){
                builder.setParameters(NVPairs.pairs(params));
            }
            URI uri = builder.build();
            httpGet = new HttpGet(uri);
            logger.info("url===> {}", httpGet.getURI().toString());

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout)
                    .setSocketTimeout(readTimeout)
                    .build();
            httpGet.setConfig(requestConfig);
            httpGet.releaseConnection();

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
//            CloseUtil.closeQuietly(response);
//            releaseConnection(httpGet);
//            CloseUtil.closeQuietly(httpClient);
        }
        return data;
    }

    public static void main(String[] args) {
       /* for(int i = 0; i < 5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpGets.create("http://www.baidu.com").submit();
                }
            }).start();
        }*/

        for(int i = 0; i < 50; i++){
            HttpGets.create("http://www.baidu.com").submit();
        }
    }
}
