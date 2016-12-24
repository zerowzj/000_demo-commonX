package com.company.util.http;

import com.company.util.CloseUtil;
import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 *
 * @author wangzhj
 */
public class HttpPostsx {

    private static final Logger logger = LoggerFactory.getLogger(HttpPostsx.class);

    /** URL */
    private String url = null;
    /** 参数 */
    private Map<String, String> params = null;

    /** 连接超时时间 */
    private long connectTimeout = 30 * 1000;
    /** 读取超时时间 */
    private long readTimeout = 60 * 1000;

    private Charset charset = Charsets.UTF_8;

    private HttpPostsx(String url, Map<String, String> params){
        this.url = url;
        this.params = params;
    }

    public static HttpPostsx build(String url, Map<String, String> params){
        return new HttpPostsx(url, params);
    }

    public HttpPostsx connectTimeout(long connectTimeout){
        this.connectTimeout = connectTimeout;
        return this;
    }

    public HttpPostsx readTimeout(long readTimeout){
        this.readTimeout = readTimeout;
        return this;
    }

    public HttpPostsx charset(Charset charset){
        this.charset = charset;
        return this;
    }

    public void postJson() {
        byte[] data = post(Entitys.createJsonEntity(params));
    }

    public void postForm() {
        byte[] data = post(Entitys.createUrlEncodedFormEntity(params));
    }

    private byte[] post(HttpEntity httpEntity) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(httpEntity);

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
            CloseUtil.closeQuietly(response);
            CloseUtil.closeQuietly(httpClient);
        }
        return result;
    }
}
