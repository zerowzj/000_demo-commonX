package com.company.validation.xml;

import java.util.List;

/**
 * 参数集合
 *
 * @author wangzhj
 */
public class ParamSet {

	/** 关键字 */
	private String key = null;
	/** 参数列表 */
	private List<Param> paramLt = null;

	public List<Param> getParamLt() {
		return paramLt;
	}

	public void setParamLt(List<Param> paramLt) {
		this.paramLt = paramLt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
