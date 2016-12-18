package com.moli.blog.model;

import java.util.Date;

public class CommentsBo {
	/**
	 * 主键
	 */
	private long id;
	/**
	 * 博客id
	 */
	private long blogid;
	/**
	 * 评论id
	 */
	private long comid;
	/**
	 * 评论名称
	 */
	private String comname;
	/**
	 * 评论时间
	 */
	private Date comtime;
	/**
	 * 评论
	 */
	private String comments;
	/**
	 * 更新时间
	 */
	private Date modifytime;
	/**
	 * 是否删除
	 */
	private Integer isdelete;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBlogid() {
		return blogid;
	}
	public void setBlogid(long blogid) {
		this.blogid = blogid;
	}
	public long getComid() {
		return comid;
	}
	public void setComid(long comid) {
		this.comid = comid;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public Date getComtime() {
		return comtime;
	}
	public void setComtime(Date comtime) {
		this.comtime = comtime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
}
