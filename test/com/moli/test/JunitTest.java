package com.moli.test;
/**
 * service单元测试
 * 该实列只依赖于spring上下文（spring容器），不依赖于web容器的测试
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moli.blog.service.IBlogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/moli/blog/config/app-context.xml")
public class JunitTest{
	//	@Resource(name = "blogservice")
	//	name必须和实现类名一致
	@Autowired
	//自动注解，先根据名字，再根据类型去找类
    //@Autowired与Resource区别：
	//@Autowired不用写实现类名，但是一个接口多个实现类时候不知道使用哪个实现类报错。
	//@Autowired下加入@Qualifier（"blogservice"）也可以实现@Resource(name = "blogservice")指定注入类
	private IBlogService iBlogService;
	//定义接口属性，比定义实现类灵活
	@Test
	public void testTest(){
		System.out.println("laownagzhu");
		System.out.println(iBlogService);
	}
	
	
}
