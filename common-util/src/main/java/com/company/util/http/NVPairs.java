package com.company.util.http;

import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/24.
 */
abstract class NVPairs {

    /**
     *
     */
    public static List<NameValuePair> pairs(Map<String, String> params) {
        List<NameValuePair> pairLt = Lists.newArrayList();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            pairLt.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return pairLt;
    }
}
