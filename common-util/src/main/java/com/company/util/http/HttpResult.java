package com.company.util.http;

import org.apache.http.Header;

/**
 * Created by wangzhj on 2016/12/30.
 */
public class HttpResult {

    //
    private boolean isOK = true;
    //状态码
    private int statusCode = 0;
    //响应头部
    private Header[] headers = null;
    //响应实体
    private byte[] data = null;

    public HttpResult(int statusCode, Header[] headers, byte[] data) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.data = data;
    }

    public boolean isOK() {
        return statusCode == 200;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public byte[] getData() {
        return data;
    }

    public Header[] getHeaders() {
        return headers;
    }
}
