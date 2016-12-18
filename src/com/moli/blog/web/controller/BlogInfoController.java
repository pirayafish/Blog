package com.moli.blog.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.core.model.Response;
import com.moli.blog.model.BlogInfoBo;
import com.moli.blog.model.CommentsBo;
import com.moli.blog.service.IBlogService;

@Controller("bloginfocontroller")
@RequestMapping("/blog")
public class BlogInfoController {
	@Resource(name = "blogservice")
	private IBlogService blogService;
	@RequestMapping("/addblog")
	@ResponseBody
	public String addBlog(BlogInfoBo blogInfoBo,HttpServletRequest req){
		System.out.println(req.getParameter("moli"));
		Response<Long> res = null;
		try {
			Long blogid = blogService.addBlog(blogInfoBo);
			res = new Response<>(blogid);
			return res.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			res = new Response<>(Response.ERROR.SYS_ERROR);
			return res.toJSONString();
		}
	}
	
	@RequestMapping("/deleteblog")
	@ResponseBody
	public String deleteBlog(Long id,HttpServletRequest req){
		
		Response<Integer> res = null;
		try {
			Integer affectRow = blogService.deleteBlog(id);
			res = new Response<>(affectRow);
			return res.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			res = new Response<>(Response.ERROR.SYS_ERROR);
			return res.toJSONString();
		}
	}
	
	@RequestMapping("/updateblog")
	@ResponseBody
	public String updateBlog(BlogInfoBo blogInfoBo,HttpServletRequest req){
		
		Response<Integer> res = null;
		try {
			Integer blogid = blogService.updateBlog(blogInfoBo);
			res = new Response<>(blogid);
			return res.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			res = new Response<>(Response.ERROR.SYS_ERROR);
			return res.toJSONString();
		}
	}
	
	@RequestMapping("/showblog")
	@ResponseBody
	public String showBlog(Long id,HttpServletRequest req){
		
		Response<BlogInfoBo> res = null;
		try {
			BlogInfoBo blogInfo = blogService.showBlog(id);
			res = new Response<>(blogInfo);
			return res.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			res = new Response<>(Response.ERROR.SYS_ERROR);
			return res.toJSONString();
		}
	}
	@RequestMapping("/addcomments")
	@ResponseBody
	public String addComments(CommentsBo comments,HttpServletRequest req){
		
		Response<Integer> res = null;
		try {
			Integer rows = blogService.addComment(comments);
			res = new Response<>(rows);
			return res.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			res = new Response<>(Response.ERROR.SYS_ERROR);
			return res.toJSONString();
		}
	}
}
