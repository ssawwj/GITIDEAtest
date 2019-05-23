package com.ss.ssm.dao;

import java.util.List;

import com.ss.ssm.entity.Emp;

public interface EmpDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer id);
    
    Emp selectByPrimaryKeyWithDept(Integer id);
    
    List<Emp> selectByWithDept(Emp emp);
    
    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}