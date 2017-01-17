package com.company.util.http;

import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.Map;

/**
 * Created by wangzhj on 2016/12/29.
 */
public class Headers {

    /**
     * 生成表单实体
     *
     * @param headerMap
     * @return Header[]
     */
    public static Header[] create(Map<String, String> headerMap) {
        Header[] headerArray = ObjectArrays.newArray(Header.class, 0);
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            Header header = new BasicHeader(entry.getKey(), entry.getValue());
            headerArray = ObjectArrays.concat(header, headerArray);
        }
        return headerArray;
    }

    public static void main(String[] args) {
        Map<String, String> headers = Maps.newTreeMap();
        headers.put("1", "adsfa");
        headers.put("2", "adsfa");
        headers.put("3", "adsfa");
        headers.put("4", "adsfa");
        create(headers);
    }
}
