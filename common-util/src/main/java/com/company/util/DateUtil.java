package com.company.util;

import java.text.SimpleDateFormat;

/**
 * Date Util
 *
 * @author wangzhj
 */
public abstract class DateUtil {

    /**
     * 是否是指定格式日期
     *
     * @param dateStr
     * @param format
     * @return boolean
     */
    public static boolean isFormatDate(String dateStr, String format) {
        if (dateStr == null || format == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        boolean is = true;
        try {
            sdf.setLenient(false);
            sdf.parse(dateStr);
        } catch (Exception ex) {
            is = false;
        }
        return is;
    }
}
