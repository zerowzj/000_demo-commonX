package com.company.util.http;

import com.google.common.base.Charsets;
import org.apache.http.client.methods.HttpRequestBase;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Http请求
 *
 * @author wangzhj
 */
abstract class Https {

    /** URL */
    protected String url = null;

    /** 请求参数 */
    protected Map<String, String> paramMap = null;
    /** 上传文件 */
    protected Map<String, byte[]> fileMap = null;

    /** 编码 */
    protected Charset charset = Charsets.UTF_8;
    /** 请求头 */
    protected Map<String, String> headerMap = null;

    /** 连接超时时间 */
    protected int connectTimeout = 20 * 1000;
    /** 读取超时时间 */
    protected int readTimeout = 20 * 1000;

    protected Https(String url, Map<String, String> paramMap) {
        this.url = url;
        this.paramMap = paramMap;
    }

    protected Https(String url, Map<String, String> paramMap, Map<String, byte[]> fileMap) {
        this.url = url;
        this.paramMap = paramMap;
        this.fileMap = fileMap;
    }

    public final Https connectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public final Https readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public final Https charset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public final Https headers(Map<String, String> headerMap) {
        this.headerMap = headerMap;
        return this;
    }

    /**
     * 释放连接
     *
     * @param httpRequest
     */
    public final void releaseConnection(HttpRequestBase httpRequest) {
        if (httpRequest != null) {
            httpRequest.releaseConnection();
        }
    }

    /**
     * 同步提交
     *
     * @return byte[]
     */
    public abstract byte[] submit();

    /**
     * 异步提交
     *
     * @return byte[]
     */
    public abstract void asyncSubmit();
}
