package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
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
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author wangzhj
 */
public class HttpPosts {

    private static final Logger logger = LoggerFactory.getLogger(HttpPosts.class);

    private String url = null;

    private Map<String, String> params = null;

    private BodyFormat bodyFormat = BodyFormat.FORM;

    private Charset charset = Charsets.UTF_8;


    private long connectTimeout = 30 * 1000;

    private long readTimeout = 60 * 1000;

    private HttpPosts(String url, Map<String, String> params) {
        this.url = url;
        this.params = params;
    }

    public static HttpPosts build(String url, Map<String, String> params) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "url is not null or empty");
        return new HttpPosts(url, params);
    }

    public HttpPosts charset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public HttpPosts bodyFormat(BodyFormat format) {
        this.bodyFormat = format;
        return this;
    }

    public HttpPosts connectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public HttpPosts readTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    /**
     * 提交
     *
     * @return byte[]
     */
    public byte[] post() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            HttpEntity httpEntity = null;
            if(bodyFormat == BodyFormat.FORM){
                httpEntity = Entitys.createUrlEncodedFormEntity(params, charset);
            } else if(bodyFormat == BodyFormat.JSON) {
                httpEntity = Entitys.createJsonEntity(params, charset);
            }
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
        FORM, JSON
    }

    public static void main(String[] args) {
        Map params = Maps.newTreeMap();
        params.put("userName", "admin");
        params.put("token", "123");
        byte[] data = HttpPosts.build("http://localhost:8080/demo/list", params).bodyFormat(BodyFormat.JSON).post();
        logger.info(new String(data));
    }
}
