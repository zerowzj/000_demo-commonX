package com.company.util.http;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.http.HttpEntity;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/27.
 */
public abstract class Https {

    protected String url = null;

    protected Map<String, String> params = null;

    protected Map<String, byte[]> files = null;

    protected Charset charset = Charsets.UTF_8;

    protected int connectTimeout = 2 * 1000;

    protected int readTimeout = 2 * 1000;

    protected Https(String url, Map<String, String> params) {
        this.url = url;
        this.params = params;
    }

    protected Https(String url, Map<String, String> params, Map<String, byte[]> files) {
        this.url = url;
        this.params = params;
        this.files = files;
    }

    public Https connectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public Https readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public Https charset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public abstract byte[] submit();
}
