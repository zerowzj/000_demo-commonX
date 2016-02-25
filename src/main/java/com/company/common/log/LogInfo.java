package com.company.common.log;

/**
 * 日志信息
 * 
 * @author wangzhj
 */
public class LogInfo {

	/** 信息 */
	private StringBuffer subInfo = new StringBuffer();
	
	/**
	 * 附加信息
	 * 
	 * @param info
	 * @return LogInfo
	 */
	public LogInfo append(String info){
		subInfo.append(info);
		return this;
	}
	
	/**
	 * 获取信息
	 * 
	 * @return String
	 */
	public String getInfo() {
		return subInfo.toString();
	}
}
