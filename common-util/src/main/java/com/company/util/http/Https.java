package com.company.util.http;

import com.google.common.base.Charsets;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Http请求
 *
 * @author wangzhj
 */
abstract class Https {

    /**
     * URL
     */
    protected String url = null;
    /**
     * 请求参数
     */
    protected Map<String, String> params = null;
    /**
     * 上传文件
     */
    protected Map<String, byte[]> files = null;
    /**
     * 编码
     */
    protected Charset charset = Charsets.UTF_8;

    /**
     * 连接超时时间
     */
    protected int connectTimeout = 2 * 1000;
    /**
     * 读取超时时间
     */
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
     * 提交
     *
     * @return byte[]
     */
    public abstract byte[] submit();

    protected static PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

    static {
        //连接池最大生成连接数200
        connManager.setMaxTotal(100);

    }
}
