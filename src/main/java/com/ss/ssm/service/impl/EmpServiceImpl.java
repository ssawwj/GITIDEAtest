package com.ss.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ssm.dao.DeptDao;
import com.ss.ssm.dao.EmpDao;
import com.ss.ssm.entity.Dept;
import com.ss.ssm.entity.Emp;
import com.ss.ssm.service.DeptService;
import com.ss.ssm.service.EmpService;

/**
	@author ss
	@date 2019年5月21日 下午3:56:03
**/
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpDao empDao;
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return empDao.selectByWithDept(null);
	}

	/**
	 * 员工保存
	 * @param emp
	 */
	public void saveEmp(Emp emp) {
		// TODO Auto-generated method stub
		empDao.insertSelective(emp);
	}
}
