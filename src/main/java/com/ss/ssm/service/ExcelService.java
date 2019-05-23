package com.ss.ssm.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ss.ssm.entity.Emp;

/**
	@author ss
	@date 2019年5月1日 下午4:08:23
**/

public interface ExcelService{
	
	
	public void importExcelInfo(InputStream in, MultipartFile file);
}
