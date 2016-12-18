package com.moli.blog.model;

import java.util.Date;

public class BlogInfoBo {
	/**
	 * 主键
	 */
	private long id;
	/**
	 * 用户id
	 */
	private long userid;
	/**
	 * 博客名称
	 */
	private String title;
	/**
	 * 副标题
	 */
	private String subtile;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 提交时间
	 */
	private Date posttime;
	/**
	 * 更新时间
	 */
	private Date updatetime;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 标签
	 */
	private String tags;
	/**
	 * 收藏数
	 */
	private Integer stars;
	/**
	 * 评论数
	 */
	private Integer commentsnu;
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
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtile() {
		return subtile;
	}
	public void setSubtile(String subtile) {
		this.subtile = subtile;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public Integer getCommentsnu() {
		return commentsnu;
	}
	public void setCommentsnu(Integer commentsnu) {
		this.commentsnu = commentsnu;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}
