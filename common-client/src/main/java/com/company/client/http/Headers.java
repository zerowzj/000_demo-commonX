package com.company.client.http;

import com.google.common.collect.ObjectArrays;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.Map;

/**
 * 头部处理
 *
 * @author wangzhj
 */
public class Headers {

    /**
     * 生成头部数组
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
}
