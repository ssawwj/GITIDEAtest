package com.ss.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ss.ssm.entity.Dept;

public interface DeptDao {
    int deleteByPrimaryKey(Integer deid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    List<Dept> selectByExample(Dept dept);

	void insertDeptList(List<Dept> deptList);

	List<Dept> findByPageSel(Map<String, Object> map);
}