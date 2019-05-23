package com.ss.ssm.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ss.ssm.dao.DeptDao;
import com.ss.ssm.entity.Dept;
import com.ss.ssm.service.DeptService;
import com.ss.ssm.utils.ExcelUtil;

/**
	@author ss
	@date 2019年5月21日 下午3:56:03
**/
@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptDao deptdao;
	
	public List<Dept> getDepts() {
		// TODO Auto-generated method stub
		List<Dept> list = deptdao.selectByExample(null);
		return list;
	}
	/**
	 * excel导入
	 * @param in
	 * @param file
	 */
	public void importExcelInfo(InputStream in, CommonsMultipartFile file) {
		 try{ 	
	            List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
	            List<Dept> deptList = new ArrayList<Dept>();
	            //遍历listob数据，把数据放到List中
	            for (int i = 0; i < listob.size(); i++) {
	                List<Object> ob = listob.get(i);
	                Dept dept =new Dept();
	                dept.setDeid(Integer.parseInt(ob.get(0).toString()));
	              	dept.setDename(String.valueOf(ob.get(1)));
	              	deptList.add(dept);
	            }
	            deptdao.insertDeptList(deptList);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	}
	
	public List<Dept> findByPageSel(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return deptdao.findByPageSel(map);
	}
}
