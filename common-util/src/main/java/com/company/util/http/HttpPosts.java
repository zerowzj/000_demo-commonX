package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Http Post请求
 *
 * @author wangzhj
 */
public class HttpPosts extends HttpMethod {

    private static final Logger logger = LoggerFactory.getLogger(HttpPosts.class);

    //请求实体格式
    private BodyFormat bodyFormat = BodyFormat.FORM;

    private HttpPosts(String url, Map<String, String> params, Map<String, byte[]> files) {
        super(url, params, files);
    }

    /**
     * 创建HttpPosts
     *
     * @param url
     * @param params
     * @return HttpPosts
     */
    public static HttpPosts create(String url, Map<String, String> params) {
        return create(url, params, null);
    }

    /**
     * 创建HttpPosts
     *
     * @param files
     * @param url
     * @return HttpPosts
     */
    public static HttpPosts create(Map<String, byte[]> files, String url) {
        Preconditions.checkArgument(!(files == null || files.isEmpty()), "files is not null or empty");
        return create(url, null, files);
    }

    /**
     * 创建HttpPosts
     *
     * @param url
     * @param params
     * @param files
     * @return HttpPosts
     */
    public static HttpPosts create(String url, Map<String, String> params, Map<String, byte[]> files) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is not null or empty");
        return new HttpPosts(url, params, files);
    }

    public HttpPosts bodyFormat(BodyFormat format) {
        this.bodyFormat = format;
        return this;
    }

    private HttpPost buildHttpPost() {
        HttpPost httpPost = null;
        try {
            //===>请求实体
            HttpEntity httpEntity = null;
            if (bodyFormat == BodyFormat.FORM) {
                httpEntity = Entitys.createUrlEncodedFormEntity(paramMap, charset);
            } else if (bodyFormat == BodyFormat.JSON) {
                httpEntity = Entitys.createJsonEntity(paramMap, charset);
            } else if (bodyFormat == BodyFormat.MULTIPART) {
                Preconditions.checkArgument(!(fileMap == null || fileMap.isEmpty()), "upload file is not null or empty");
                httpEntity = Entitys.createMultipartEntity(paramMap, fileMap);
            }
            //===>配置
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout)
                    .setSocketTimeout(readTimeout)
                    .build();
            httpPost = new HttpPost(url);
            httpPost.setEntity(httpEntity);
            httpPost.setConfig(requestConfig);
            //===>请求头
            if (headerMap != null && !headerMap.isEmpty()) {
                httpPost.setHeaders(Headers.create(headerMap));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return httpPost;
    }

    @Override
    public HttpPosts submit() {
        CloseableHttpClient httpClient = SyncClients.getHttpClient();

        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        try {
            //===>
            httpPost = buildHttpPost();
            logger.info(" request url===> {}", httpPost.getURI().toString());
            logger.info("request body===> {}", EntityUtils.toString(httpPost.getEntity()));
            //===>
            response = httpClient.execute(httpPost);
            //===>
            parseHttpResponse(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            CloseUtil.closeQuietly(response);
            CloseUtil.closeQuietly(httpClient);
            releaseConnection(httpPost);
        }
        return this;
    }

    @Override
    public HttpMethod asyncSubmit() {
        return this;
    }

    /**
     * 实体格式
     */
    public enum BodyFormat {
        FORM, JSON, MULTIPART
    }
}
