package com.company.util.http;

import com.company.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2016/12/23.
 */
abstract class Entitys {

    /**
     * 生成表单实体
     *
     * @param params
     * @param charset
     * @return HttpEntity
     */
    public static HttpEntity createUrlEncodedFormEntity(Map<String, String> params, Charset charset) {
        List<NameValuePair> pairLt = NVPairs.pairs(params);
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(pairLt, charset);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return formEntity;
    }


    /**
     * 生成Json实体
     *
     * @param params
     * @param charset
     * @return HttpEntity
     */
    public static HttpEntity createJsonEntity(Map<String, String> params, Charset charset) {
        String json = JsonUtil.toJson(params);
        StringEntity stringEntity = new StringEntity(json, charset.toString());
        stringEntity.setContentEncoding(charset.toString());
        stringEntity.setContentType(ContentType.APPLICATION_JSON.getMimeType());

        return stringEntity;
    }

    /**
     * 生成Multipart实体
     *
     * @param params
     * @param files
     * @return HttpEntity
     */
    public static HttpEntity createMultipartEntity(Map<String, String> params, Map<String, byte[]> files) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        //文件
        if(files != null){
            for (Map.Entry<String, byte[]> entry : files.entrySet()) {
                builder.addBinaryBody(entry.getKey(), entry.getValue(), ContentType.DEFAULT_BINARY, entry.getKey());
            }
        }
        //参数
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addTextBody(entry.getKey(), entry.getValue());
            }
        }
        HttpEntity httpEntity = builder.build();
        return httpEntity;
    }
}
