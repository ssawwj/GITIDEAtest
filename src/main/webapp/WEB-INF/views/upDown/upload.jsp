<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多文件上传</title>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
   <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/jquery-1.12.4.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	 <form  id ="form5" action="${APP_PATH }/upload3" enctype="multipart/form-data" method="post">
	     <input type = "file" name= 'file' />
	     <input type = "file" name= 'file' />
	     <input type = "file" name= 'file' />
	     <input type="text" name="name" value="dzf"/>
	     <input type="button" id = "button2" value="多文件ajax上传" onclick="fileupload3()">
	    <input type ="submit" value="多文件直接上传">
	</form> 
</body>
	<script type="text/javascript">
	function fileupload3(){
		      var formData = new FormData($("#form5")[0]);
		          $.ajax({
		                  url:'${APP_PATH }/upload3',
		                  type:'post',
		                  data:formData,
		                  //必须false才会自动加上正确的Content-Type
		                  contentType: false,
		                  //必须false才会避开jQuery对 formdata 的默认处理
		                 //XMLHttpRequest会对 formdata 进行正确的处理
		                 processData: false,
		                 success:function(data){
		                     alert(data);
		                 },
		                 error:function(data){
	                    	alert(data);
		                     alert("后台发生异常");
		                 },
		                 cache:false,
		                 async:true
		             }); 
		 }
	</script>
</html>