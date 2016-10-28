package com.company.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * HttpRequest Util
 *
 * @author wangzhj
 */
public abstract class HttpRequestUtil {

    private static final String AJAX_HEADER = "X-Requested-With";

    private static final String AJAX_VALUE = "XMLHttpRequest";

    private static final String MULTIPART = "multipart/";

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
     * 是否是上传请求
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
}
