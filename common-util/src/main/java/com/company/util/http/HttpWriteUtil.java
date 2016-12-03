package com.company.util.http;

import com.company.util.JsonUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Write Util
 *
 * @author wangzhj
 */
public class HttpWriteUtil {

    private static final String CHARSET_UTF_8 = "UTF-8";

    /**
     * 写到客户端
     *
     * @param response
     * @param obj
     */
    public static void writeByJson(HttpServletResponse response, Object obj) {
        write(response, JsonUtil.toJson(obj));
    }

    /**
     * 写到客户端
     *
     * @param response
     * @param msg
     */
    public static void write(HttpServletResponse response, String msg) {
        write(response, msg, CHARSET_UTF_8);
    }

    /**
     * 写到客户端
     *
     * @param response
     * @param msg
     * @param charset
     */
    public static void write(HttpServletResponse response, String msg, String charset) {
        PrintWriter out = null;
        try {
            response.setContentType("text/plain;charset=" + charset);
            out = response.getWriter();
            out.write(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
