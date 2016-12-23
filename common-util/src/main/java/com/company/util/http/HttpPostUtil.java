package com.company.util.http;

import com.company.util.CloseUtil;
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
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public class HttpPostUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpPostUtil.class);

    public void postForm(String url, Map<String, String> params) {

        post(url, Entitys.createUrlEncodedFormEntity(params), "");

    }

    private static byte[] post(String url, HttpEntity entity, String charset) {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);

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
