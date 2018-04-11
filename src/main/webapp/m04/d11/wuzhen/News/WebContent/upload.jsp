
<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
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
SmartUpload su=new SmartUpload();
su.initialize(super.getServletConfig(), request, response);
String canLoad="jpg,png";
String unLoad="exe,rar,jsp";
File upload;//接收文件流；
su.setAllowedFilesList(canLoad);//设置能上传的文件格式；
su.setDeniedFilesList(unLoad);//设置不能上传的文件格式；
su.setMaxFileSize(1*1024*1024);
su.setCharset("utf-8");
su.upload();
upload=su.getFiles().getFile(0);
//存放路径
String path1="upload/";
String fileName="";
if(!upload.isMissing()){
    fileName=upload.getFileName();
    path1=path1+fileName;
    upload.saveAs(path1, su.SAVE_VIRTUAL);    
}
String ntitle=su.getRequest().getParameter("ntitle");
String nauthor=su.getRequest().getParameter("nauthor");
String nsummary=su.getRequest().getParameter("nsummary");
String ncontent=su.getRequest().getParameter("ncontent");

session.setAttribute("ntitle", ntitle);
session.setAttribute("nauthor", nauthor);
session.setAttribute("nsummary", nsummary);
session.setAttribute("ncontent", ncontent);
request.setAttribute("path", path1);
request.setAttribute("fileName",fileName);
request.getRequestDispatcher("show.jsp").forward(request,response);
%>
</body>
</html>