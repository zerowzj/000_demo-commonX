package com.company.util.http;

import com.company.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
abstract class Entitys {

    public static HttpEntity createUrlEncodedFormEntity(Map<String, String> params, Charset charset) {
        List<NameValuePair> pairLt = NameValuePairs.pairs(params);
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(pairLt, charset);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return formEntity;
    }

    public static HttpEntity createJsonEntity(Map<String, String> params, Charset charset) {
        String json = JsonUtil.toJson(params);

        StringEntity stringEntity = new StringEntity(json, charset.toString());
        stringEntity.setContentEncoding(charset.toString());
        stringEntity.setContentType("application/json");

        return stringEntity;
    }
}
