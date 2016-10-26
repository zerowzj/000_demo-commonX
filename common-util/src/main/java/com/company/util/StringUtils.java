package com.company.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * 字符串Utils
 * 
 * @author wangzhj
 */
public class StringUtils {
	
	/** 正则需要转义字符 */
	private static final String[] escape = new String[]{"*", "+", ".","?", "\\", "^", "|", "(", ")", "[", "]", "{", "}"};
	
	/**
	 * 
	 * 
	 * @param str
	 * @param regex
	 * @return String
	 */
	public static String substringLastBefore(String str, String regex) {
		if (trimToNull(str) == null) {
			return str;
		}
		String[] strArr = str.split(escape(regex));
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArr.length - 1; i++) {
			sb.append(strArr[i]);
			if(i != strArr.length - 2){
				sb.append(regex);
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * 
	 * @param str
	 * @return String
	 */
	public static String remove(String str, String regex) {
		if (trimToNull(str) == null) {
			return str;
		}
		String[] strArr = str.split(regex);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArr.length; i++) {
			sb.append(strArr[i]);
		}
		return sb.toString();
	}
	
	public static String replace(String str, String regex) {
		return null;
	}

	/**
	 * 
	 * 
	 * @param str
	 * @return String
	 */
	public static String trimToNull(String str) {
		if (str == null) {
			return null;
		} else {
			str = str.trim();
			if ("".equals(str)) {
				return null;
			}
		}
		return str.trim();
	}
	
	private static String escape(String regex){
		for(String key : escape){
			if(key.equals(regex)){
				regex = regex.replace(regex, "\\"+regex);
				break;
			}
		}
		return regex;
	}
	
	/**
	 * 返回流的字符串
	 * 
	 * @param in
	 * @return String
	 */
	public static String toString(InputStream in){
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		//
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {
			while((line = reader.readLine()) != null){
				sb.append(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}
}
