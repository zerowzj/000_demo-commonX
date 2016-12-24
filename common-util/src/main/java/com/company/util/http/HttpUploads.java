package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author wangzhj
 */
public class HttpUploads {

    private static final Logger logger = LoggerFactory.getLogger(HttpUploads.class);

    /**
     * URL
     */
    private String url = null;
    /**
     * 参数
     */
    private Map<String, String> params = null;
    /**
     * 参数
     */
    private Map<String, File> files = null;


    /**
     * 连接超时时间
     */
    private long connectTimeout = 30 * 1000;
    /**
     * 读取超时时间
     */
    private long readTimeout = 60 * 1000;

    private Charset charset = Charsets.UTF_8;

    private HttpUploads(String url) {
        this.url = url;
    }

    public static HttpUploads build(String url) {
        return new HttpUploads(url);
    }

    public HttpUploads addFiles(Map<String, File> files) {
        return this;
    }

    public HttpUploads addTexts(Map<String, String> texts) {
        return this;
    }

    public HttpUploads connectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public HttpUploads readTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public HttpUploads charset(Charset charset) {
        this.charset = charset;
        return this;
    }

    /**
     *
     *
     * @return
     */
    public byte[] upload() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] result = null;
        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            FormBodyPart fileBody = FormBodyPartBuilder.create().setField("", "").build();
            builder.addPart(fileBody);
            HttpEntity httpEntity = builder.build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(httpEntity);
            logger.info("url===> {}", httpPost.getURI().toString());

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

    public static void main(String[] args) {
        Map params = Maps.newTreeMap();
        params.put("userName", "admin");
        params.put("token", "123");

    }
}
