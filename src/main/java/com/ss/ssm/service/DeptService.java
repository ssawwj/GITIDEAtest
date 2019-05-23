package com.ss.ssm.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ss.ssm.entity.Dept;

/**
	@author ss
	@date 2019年5月13日 上午10:38:21
**/
@Service
public interface DeptService {
	public List<Dept> getDepts();

	public void importExcelInfo(InputStream in, CommonsMultipartFile file);
	
	List<Dept> findByPageSel(Map<String, Object> map);
}
