package com.company.util.servlet;

import com.company.util.CloseUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * HttpRequest Util
 *
 * @author wangzhj
 */
public abstract class RequestUtil {

    public static final String AJAX_HEADER = "X-Requested-With";

    public static final String AJAX_VALUE = "XMLHttpRequest";

    public static final String MULTIPART = "multipart/";

    /**
     * 是否是Ajax请求
     *
     * @param request
     * @return boolean
     */
    public static boolean isAjax(HttpServletRequest request) {
        String xRequested = request.getHeader(AJAX_HEADER);
        if (AJAX_VALUE.equals(xRequested)) {
            return true;
        }
        return false;
    }

    /**
     * 是否是同步请求
     *
     * @param request
     * @return boolean
     */
    public static boolean isSync(HttpServletRequest request) {
        String xRequested = request.getHeader(AJAX_HEADER);
        if (xRequested == null) {
            return true;
        }
        return false;
    }

    /**
     * 是否是文件上传请求
     *
     * @param request
     * @return String
     */
    public static boolean isMultipart(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return false;
        }
        if (contentType.toLowerCase(Locale.ENGLISH).startsWith(MULTIPART)) {
            return true;
        }
        return false;
    }

    /**
     * 提取HttpServletRequest参数
     *
     * @param request
     * @return Map<String, Object>
     */
    public static Map<String, Object> extractParam(HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String key = (String) enums.nextElement();
            String[] value = request.getParameterValues(key);
            if (value.length == 1) {
                map.put(key, value[0]);
            } else {
                map.put(key, Arrays.asList(value));
            }
        }
        return map;
    }

    /**
     * 获取请求实体
     *
     * @param request
     * @return String
     */
    public static String getBodyString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            CloseUtil.closeQuietly(is);
            CloseUtil.closeQuietly(reader);
        }
        return sb.toString();
    }
}
