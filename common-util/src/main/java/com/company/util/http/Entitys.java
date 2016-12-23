package com.company.util.http;

import com.google.common.collect.Lists;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
abstract class Entitys {

    public static HttpEntity createUrlEncodedFormEntity(Map<String, String> params) {
        List<NameValuePair> pairLt = Lists.newArrayList();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            pairLt.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(pairLt);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return formEntity;
    }
}
