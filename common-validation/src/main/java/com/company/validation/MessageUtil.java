package com.company.validation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * <p>Title: MessageUtil<／p>
 * <p>Description: ${DESC}<／p>
 *
 * @author wangzhj
 * @time 2016-11-04 16:47
 */
public abstract class MessageUtil {

    private static final String MESSAGE_FILE = "message.properties";

    private static final Properties prop = new Properties();

    static {
        InputStream is = ClassLoader.getSystemResourceAsStream(MESSAGE_FILE);
        try {
            prop.load(new InputStreamReader(is, "UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getMinLength() {
        return prop.get("param.error.min_length").toString();
    }

    public static void main(String[] args) {

        System.out.println(MessageUtil.getMinLength());
    }
}
