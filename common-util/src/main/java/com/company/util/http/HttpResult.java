package com.company.util.http;

import org.apache.http.Header;

/**
 * Created by wangzhj on 2016/12/30.
 */
public class HttpResult {

    private boolean isOK = true;

    private int statusCode = 0;

    private byte[] data = null;

    private Header[] headers = null;

    public HttpResult(int statusCode, byte[] data, Header[] headers){
        this.statusCode = statusCode;
        this.data = data;
        this.headers = headers;
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
