package com.moli.blog.service;

import java.util.List;

import com.moli.blog.model.BlogInfoBo;
import com.moli.blog.model.CommentsBo;

public interface IBlogService {
	/**
	 * 新增博客
	 * @param blogInfoBo 博客对象
	 * @return 新增主键id
	 */
	public Long addBlog(BlogInfoBo blogInfoBo);
	/**
	 * 修改博客
	 * @param blogInfoBo 博客对象
	 * @return 影响条数
	 */
	public Integer updateBlog(BlogInfoBo blogInfoBo);
	/**
	 * 删除博客
	 * @param id 博客id
	 * @return 影响条数
	 */
	public Integer deleteBlog(Long id);
	/**
	 * 展示博客
	 * @param id 博客id
	 * @return 博客对象
	 */
	public BlogInfoBo showBlog(Long id);
	/**
	 * 博客列表
	 * @param blogInfoBo 博客对象
	 * @return 博客列表
	 */
	public List<BlogInfoBo> listBlog(BlogInfoBo blogInfoBo);
	/**
	 * 新增评论.
	 * @param comment 评论
	 * @return 返回评论数
	 */
	public int addComment(CommentsBo comment);
}
