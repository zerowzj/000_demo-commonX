package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Map;

/**
 * Http Post请求
 *
 * @author wangzhj
 */
public class HttpPosts extends Https {

    private static final Logger logger = LoggerFactory.getLogger(HttpPosts.class);

    /**
     * 请求实体格式
     */
    private BodyFormat bodyFormat = BodyFormat.FORM;

    private HttpPosts(String url, Map<String, String> params, Map<String, byte[]> files) {
        super(url, params, files);
    }

    public static HttpPosts create(String url, Map<String, String> params) {
        return create(url, params, null);
    }

    public static HttpPosts create(Map<String, byte[]> files, String url) {
        Preconditions.checkArgument(!(files == null || files.isEmpty()), "files is not null or empty");
        return create(url, null, files);
    }

    public static HttpPosts create(String url, Map<String, String> params, Map<String, byte[]> files) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is not null or empty");
        return new HttpPosts(url, params, files);
    }

    public HttpPosts bodyFormat(BodyFormat format) {
        this.bodyFormat = format;
        return this;
    }

    private HttpPost createHttpPost() {
        HttpPost httpPost = null;
        try {
            //===>Entity
            HttpEntity httpEntity = null;
            if (bodyFormat == BodyFormat.FORM) {
                httpEntity = Entitys.createUrlEncodedFormEntity(paramMap, charset);
            } else if (bodyFormat == BodyFormat.JSON) {
                httpEntity = Entitys.createJsonEntity(paramMap, charset);
            } else if (bodyFormat == BodyFormat.MULTIPART) {
                Preconditions.checkArgument(!(fileMap == null || fileMap.isEmpty()), "upload file is not null or empty");
                httpEntity = Entitys.createMultipartEntity(paramMap, fileMap);
            }
            //===>Post
            httpPost = new HttpPost(url);
            httpPost.setEntity(httpEntity);
            //===>头部
            if (headerMap != null && !headerMap.isEmpty()) {
                httpPost.setHeaders(Headers.create(headerMap));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return httpPost;
    }

    @Override
    public byte[] submit() {
        CloseableHttpClient httpClient = SyncClients.getHttpClient();

        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] data = null;
        try {
            //===>请求
            httpPost = createHttpPost();
            logger.info("url===> {}", httpPost.getURI().toString());
            logger.info("body===> {}", EntityUtils.toString(httpPost.getEntity()));
            //===>
            response = httpClient.execute(httpPost);
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
            CloseUtil.closeQuietly(httpClient);
            releaseConnection(httpPost);
        }
        return data;
    }

    @Override
    public void asyncSubmit() {

    }

    public enum BodyFormat {
        FORM, JSON, MULTIPART
    }
}
