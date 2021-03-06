package com.ss.ssm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.ss.ssm.entity.Emp;

/**
	@author ss
	@date 2019年5月1日 下午4:31:59
**/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:mybatis-config.xml","classpath:springMvc-config.xml"})
public class MvcTest {
	@Autowired
	WebApplicationContext context ;
	//虚假的mvc请求
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//拿到返回值
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn","1")).andReturn();
		
		//请求成功后拿到pageinfo
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi=(PageInfo )request.getAttribute("pageInfo");
		System.out.println("当前页码："+pi.getPageNum());
		System.out.println("总页码："+pi.getPages());
		System.out.println("总记录数："+pi.getTotal());
		System.out.println("在页面需要连续显示的页码");
		int[] nums =pi.getNavigatepageNums();
		for (int i : nums) {
			System.out.println("--"+i);
		}
		
		//获取员工数据
		List<Emp> list =pi.getList();
		for (Emp emp : list) {
			System.out.println("ID"+emp.getdId()+"==>NAME"+emp.getName());
		}
	}
}
