package com.company.util.http;

import com.company.util.Closeables;
import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
public class HttpPostUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpPostUtil.class);

    public void postJson(String url) {

    }

    public void postForm(String url) {

    }

    public static byte[] post(String url, Map<String, String> params, String charset) {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        UrlEncodedFormEntity formEntity = null;
        CloseableHttpResponse response = null;
        InputStream is = null;
        byte[] result = null;
        try {
            List<NameValuePair> pairLt = transform(params);
            formEntity = new UrlEncodedFormEntity(pairLt);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(formEntity);

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
            Closeables.closeQuietly(response);
            Closeables.closeQuietly(httpClient);
        }
        return result;
    }

    private static List<NameValuePair> transform(Map<String, String> params) {
        List<NameValuePair> pairLt = Lists.newArrayList();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            pairLt.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return pairLt;
    }
}
