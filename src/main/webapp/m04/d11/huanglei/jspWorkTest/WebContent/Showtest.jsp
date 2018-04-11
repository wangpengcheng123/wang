<%@page import="org.apache.tomcat.util.http.fileupload.FileUpload"%>
<%@page import="com.jspsmart.upload.*"%>
<%@page import="javax.swing.text.StyleContext.SmallAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   
	SmartUpload su=new SmartUpload();//实例化上传对象
	su.initialize(super.getServletConfig(), request, response);//初始化上传对象
	//设置规定上传文件格式
	String pass="jpg";
	String notpass="txt";
	
	File upload;
	try{
	   //可上传文件
	 su.setAllowedFilesList(pass);
	    //不可上传文件
	 su.setDeniedFilesList(notpass);
	    //设置文件格式大小
	 su.setMaxFileSize(1024*1024*10);
	 su.setCharset("utf-8");
	 su.upload();
	 upload=su.getFiles().getFile(0);//获取文件
	 String paths="upload\\";
	 String filename="";
	
	 
	 if(!upload.isMissing()){
	    
	     filename= upload.getFieldName();
	     paths+=filename;
	     upload.saveAs(paths, su.SAVE_VIRTUAL);
	 }
	 request.setAttribute("filename", filename);
	 request.setAttribute("paths", paths);
	 request.setAttribute("title",session.getAttribute("title"));
	 request.setAttribute("uname",session.getAttribute("uname"));
	 request.setAttribute("zhaiyao",session.getAttribute("zhaiyao"));
	 request.setAttribute("neirong",session.getAttribute("neirong"));
	 request.getRequestDispatcher("show.jsp").forward(request, response);
	}catch(Exception e){
	    e.printStackTrace();
	}
%>

</body>
</html>