<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tijiaoresult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    SmartUpload su=new SmartUpload();
    su.initialize(super.getServletConfig(), request, response);
    	String one="jpg,png";
    	String two="exe,rar,jsp";
    	File upload;//接收文件流
    	try{
    		//设置允许上传的文件
    		su.setAllowedFilesList(one);
    		//设置 不允许上传的文件
    		su.setDeniedFilesList(two);
    		//设置文件的大小
    		su.setMaxFileSize(5*1024*1024);//5M
    		//设置格式
    		su.setCharset("utf-8");
    		//执行上传
    		su.upload();
    		//获取文件
    		upload=su.getFiles().getFile(0);
    		String path2="upload\\";//路径
    		String filename="";//文件名
    		//思想：用另存为的方式，上传图片
    		if(!upload.isMissing()){
    			//如果文件存在，那么获取文件名
    			//filename=upload.getFileName();
    			filename=UUID.randomUUID().toString()+".jpg";
    			path2+=filename;
    			upload.saveAs(path2, su.SAVE_VIRTUAL);
    		}
    		request.setAttribute("path2", path2);
    		request.setAttribute("filename", filename);
    		request.getRequestDispatcher("admin/show.jsp").forward(request, response);
    	}catch(Exception e){
    		e.printStackTrace();
    	}    
     %>
  </body>
</html>
