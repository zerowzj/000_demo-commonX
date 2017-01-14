package com.company.util.servlet;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * HttpResponse Util
 *
 * @author wangzhj
 */
public abstract class ResponseUtil {

    public static HttpServletResponse toHttp(ServletResponse response) {
        return (HttpServletResponse) response;
    }

    /**
     * 发送错误码
     *
     * @param response
     * @param statusCode
     */
    public static void sendError(HttpServletResponse response, int statusCode) {
        try {
            response.sendError(statusCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
