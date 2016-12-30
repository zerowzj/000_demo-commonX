package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * Http Get请求
 *
 * @author wangzhj
 */
public class HttpGets extends HttpMethods {

    private static final Logger logger = LoggerFactory.getLogger(HttpGets.class);

    private HttpGets(String url, Map<String, String> params) {
        super(url, params);
    }

    /**
     * 创建HttpGets
     *
     * @param url
     * @return HttpGets
     */
    public static HttpGets create(String url) {
        return create(url, null);
    }

    /**
     * 创建HttpGets
     *
     * @param url
     * @param params
     * @return HttpGets
     */
    public static HttpGets create(String url, Map<String, String> params) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is not null or empty");
        return new HttpGets(url, params);
    }

    private HttpGet buildHttpGet() {
        HttpGet httpGet = null;
        try {
            //===>Url
            URIBuilder builder = new URIBuilder(url);
            if (paramMap != null && !paramMap.isEmpty()) {
                builder.setParameters(Entitys.pairs(paramMap));
            }
            URI uri = builder.build();
            //===>配置
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout)
                    .setSocketTimeout(readTimeout)
                    .build();
            //===>Get
            httpGet = new HttpGet(uri);
            httpGet.setConfig(requestConfig);
            //===>头部
            if (headerMap != null && !headerMap.isEmpty()) {
                httpGet.setHeaders(Headers.create(headerMap));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return httpGet;
    }

    @Override
    public HttpGets submit() {
        CloseableHttpClient httpClient = SyncClients.getHttpClient();
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        try {
            //===>请求
            httpGet = buildHttpGet();
            logger.info("url===> {}", httpGet.getURI().toString());
            //===>
            response = httpClient.execute(httpGet);
            //===>响应
            parseHttpResponse(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            releaseConnection(httpGet);
            HttpClientUtils.closeQuietly(response);
        }
        return this;
    }

    @Override
    public HttpGets asyncSubmit() {
        CloseableHttpAsyncClient httpAsyncClient = AsyncClients.createHttpClient();
        httpAsyncClient.start();

        HttpGet httpGet = null;
        HttpResponse response = null;
        try {
            //===>请求
            httpGet = buildHttpGet();
            logger.info("url===> {}", httpGet.getURI().toString());
            //===>
            Future<HttpResponse> future = httpAsyncClient.execute(httpGet, null);
            response = future.get();// 获取结果

            final CountDownLatch latch = new CountDownLatch(1);
            httpAsyncClient.execute(httpGet, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse result) {
                    latch.countDown();
                }

                @Override
                public void failed(Exception ex) {
                    latch.countDown();
                }

                @Override
                public void cancelled() {
                    latch.countDown();
                }
            });
            latch.await();

            //===>响应
            parseHttpResponse(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            releaseConnection(httpGet);
            HttpClientUtils.closeQuietly(response);
        }
        return this;
    }
}
