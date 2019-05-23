package com.ss.ssm.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ss.ssm.dao.DeptDao;
import com.ss.ssm.dao.EmpDao;
import com.ss.ssm.entity.Dept;
import com.ss.ssm.entity.Emp;

/**
	@author ss
	@date 2019年4月30日 上午10:22:28
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:mybatis-config.xml","classpath:springMvc-config.xml"})
public class MapperTest {
	
	@Autowired
	DeptDao deptDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD(){
		//1.创建springioc容器
//		ApplicationContext  ioc =new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.注入DAO
//		DeptDao bean=ioc.getBean(DeptDao.class);
			System.out.println(deptDao);
			
//			deptDao.insertSelective(new Dept(null,"开发部"));
//			deptDao.insertSelective(new Dept(null,"测试部"));
			
//			empDao.insertSelective(new Emp(null,"ss","M","904675059@qq.com",1,null));
			
			EmpDao mapper=sqlSession.getMapper(EmpDao.class);
			for(int i=0;i<1000;i++){
				String uid=UUID.randomUUID().toString().substring(0, 5)+i;
				mapper.insertSelective(new Emp(null,uid,"M",uid+"@qq.com",1,null));
			}
			System.out.println("批量完成");
			
	}
}
