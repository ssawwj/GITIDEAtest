package com.ss.ssm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ss.ssm.entity.Emp;

/**
	@author ss
	@date 2019年5月1日 下午4:08:23
**/

public interface EmpService{
	public List<Emp> getAll();
	
	public void saveEmp(Emp emp);
}
