package com.moli.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moli.blog.model.BlogInfoBo;
import com.moli.blog.web.controller.BlogInfoController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:com/moli/blog/config/app-context.xml","classpath:com/moli/blog/config/app-context-mvc.xml"})
public class BlogControllerTest {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	@Autowired
	private BlogInfoController blogInfoController;
	
	@Before
	public void setUp() throws Exception{
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
	}
	
	@Test
	public void testUse(){
		request.setParameter("moli", "baobao");
		BlogInfoBo blogInfoBo = new BlogInfoBo();
		String blogResponse = blogInfoController.addBlog(blogInfoBo, request);
		System.out.println(blogResponse);
	}
}
