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
import org.apache.http.impl.client.HttpClients;
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

    private BodyFormat bodyFormat = BodyFormat.FORM;

    private HttpPosts(String url, Map<String, String> params, Map<String, byte[]> files) {
        super(url, params, files);
    }

    public static HttpPosts create(String url, Map<String, byte[]> files) {
        return create(url, null, files);
    }

    public static HttpPosts create(String url, Map<String, String> params, Map<String, byte[]> files) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is not null or empty");
        Preconditions.checkArgument(!(files == null || files.isEmpty()), "files is not null or empty");
        return new HttpPosts(url, params, files);
    }

    public HttpPosts bodyFormat(BodyFormat format) {
        this.bodyFormat = format;
        return this;
    }

    @Override
    public byte[] submit() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(poolingConnManager)
                .build();
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] result = null;
        try {
            //生成实体
            HttpEntity httpEntity = null;
            if (bodyFormat == BodyFormat.FORM) {
                httpEntity = Entitys.createUrlEncodedFormEntity(params, charset);
            } else if (bodyFormat == BodyFormat.JSON) {
                httpEntity = Entitys.createJsonEntity(params, charset);
            } else if (bodyFormat == BodyFormat.MULTIPART) {
                httpEntity = Entitys.createMultipartEntity(params, files);
            }
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(httpEntity);
            logger.info("url===> {}", httpPost.getURI().toString());
            logger.info("body===> {}", EntityUtils.toString(httpPost.getEntity()));

            response = httpClient.execute(httpPost);

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
            CloseUtil.closeQuietly(is);
            CloseUtil.closeQuietly(response);
            CloseUtil.closeQuietly(httpClient);
        }
        return result;
    }

    public enum BodyFormat {
        FORM, JSON, MULTIPART
    }
}
