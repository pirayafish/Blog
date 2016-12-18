package com.moli.blog.model;

import javax.xml.crypto.Data;

public class TagInfoBo {
	/**
	 * 主键
	 */
	private long id;
	/**
	 * 标签名
	 */
	private String tagname;
	/**
	 * 标签使用数
	 */
	private Integer tagnumber;
	/**
	 * 更新时间
	 */
	private Data modifytime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public Integer getTagnumber() {
		return tagnumber;
	}
	public void setTagnumber(Integer tagnumber) {
		this.tagnumber = tagnumber;
	}
	public Data getModifytime() {
		return modifytime;
	}
	public void setModifytime(Data modifytime) {
		this.modifytime = modifytime;
	}
	
}
