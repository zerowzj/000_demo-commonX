package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
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
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author wangzhj
 */
public class HttpUploads {

    private static final Logger logger = LoggerFactory.getLogger(HttpUploads.class);

    private String url = null;
    private Map<String, String> params = null;
    private Map<String, byte[]> files = null;

    private long connectTimeout = 30 * 1000;
    private long readTimeout = 60 * 1000;

    private Charset charset = Charsets.UTF_8;

    private HttpUploads(String url, Map<String, byte[]> files) {
        this.url = url;
        this.files = files;
    }

    public static HttpUploads build(String url, Map<String, byte[]> files) {
        return new HttpUploads(url, files);
    }

    public HttpUploads params(Map<String, String> params) {
        this.params = params;
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
     * 上传
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
            //
            for (Map.Entry<String, byte[]> entry : files.entrySet()) {
                builder.addBinaryBody(entry.getKey(), entry.getValue(), ContentType.DEFAULT_BINARY, entry.getKey());
            }
            //
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    builder.addTextBody(entry.getKey(), entry.getValue());
                }
            }
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

    public static void main(String[] args) throws Exception {
        Map params = Maps.newTreeMap();
        params.put("userName", "admin");
        params.put("token", "123");

        Map<String, byte[]> files = Maps.newHashMap();
        files.put("file", Files.toByteArray(new File("d://win7.jpg")));
        byte[] data = HttpUploads.build("http://localhost:8080/demo/upload", files)
                .params(params)
                .upload();
        logger.info(new String(data));
    }
}
