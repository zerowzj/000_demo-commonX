package com.company.util.http;

import org.apache.http.Header;

/**
 * Created by wangzhj on 2016/12/30.
 */
public class HttpResult {

    private boolean isOK = true;

    private int statusCode = 0;

    private Header[] headers = null;

    private byte[] data = null;

    public HttpResult(int statusCode, Header[] headers, byte[] data){
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
