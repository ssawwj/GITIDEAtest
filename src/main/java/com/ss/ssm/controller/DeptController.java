package com.ss.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ss.ssm.entity.Dept;
import com.ss.ssm.entity.Msg;
import com.ss.ssm.service.DeptService;
import com.ss.ssm.utils.ExcelUtil;


/**
	@author ss
	@date 2019年5月13日 上午10:49:51
**/
@Controller
public class DeptController {
	
	private static final Logger log = LogManager.getLogger( DeptController.class);
	@Autowired
	private DeptService deptService;
	
	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		//查出的所有部门信息
		List<Dept> list = deptService.getDepts();
		return Msg.success().add("depts", list);
	}
	
	@RequestMapping("/toImp")
	public String toExcelImport(){
		return "excel/import";
	}
	
	/**
	 * Excel导入
	 * @param file
	 * @return
	 */
	@RequestMapping("/import")
    @ResponseBody
    public Msg impotrt(@RequestParam("file")CommonsMultipartFile file){
		Msg msg = new Msg();
		int row;
        try {
            InputStream in = file.getInputStream();
            deptService.importExcelInfo(in,file);
            in.close();
            msg.setMsg("ok");
            msg.setCode(200);
        }catch (Exception e){
            msg.setMsg("err");
            msg.setCode(500);
        }
        return msg;
    }
	
	/**
	 * Excel导出
	 * 
	 * @param req
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/exportExcel")
	@ResponseBody
	public Map<String, Object> exportExcel(HttpServletRequest req, HttpServletResponse response)
			throws IOException {
		List<Dept> deptList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		deptList = deptService.findByPageSel(map);
		String fileName = "部门表.xlsx";
		// 填充projects数据
		List<Map<String, Object>> list = createExcelRecord(deptList);
		String columnNames[] = { "部门id", "部门名字"};// 列名
		String keys[] = { "deid", "dename"};// map中的key
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}
	
	/**
	 * 创建excel
	 * @param projects
	 * @return
	 */
	private List<Map<String, Object>> createExcelRecord(List<Dept> projects) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "部门表");
		listmap.add(map);
		Dept project;
		for (int j = 0; j < projects.size(); j++) {
			project = projects.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("deid", project.getDeid());
			mapValue.put("dename", project.getDename());
			listmap.add(mapValue);
		}
		return listmap;
	}
	
	
	@RequestMapping("/toUpload")
	public String toUpload(){
		return "upDown/upload";
	}
	
	
	/**
	       * 多个文件上载
	       * @param request
	       * @return
	       */
	      @RequestMapping(value="/upload3",produces="text/html;charset=utf-8")
	      @ResponseBody
	      private String upload3(@RequestParam("file")CommonsMultipartFile[] partFiles,HttpServletRequest request) {
	          InputStream inputStream = null;    
	         try {
	        	 //上传后的地址，注意("/upload")是表示文件上传后的目标文件夹
	             String path = request.getServletContext().getRealPath("/upload");
	             String name = request.getParameter("name"); 
	             log.info("其他的参数{}",name);
	             log.info("upload2---------------start---------------------");
	             log.info("这个临时文件的路径是[{}]", path);
	             for (int i = 0; i < partFiles.length; i++) {
	                 String filename = partFiles[i].getOriginalFilename();
	                 log.info("文件的名字：{}",filename);
	                 File file = new File(path+"/"+filename);
	                 inputStream = partFiles[i].getInputStream();
	                 FileUtils.copyInputStreamToFile(inputStream, file);
	             }
	             if(inputStream!=null){
	                 inputStream.close();
	             }
	             return "文件上传成功！";
	         } catch (Exception e) {
	             e.printStackTrace();
	             return "文件上传失败！";
	         } 
	     }
	      
	      public static void main(String[] args) {
			String s="000000085385213637103178";
			System.out.println(String.valueOf(Long.parseLong(s)));
		}
}
