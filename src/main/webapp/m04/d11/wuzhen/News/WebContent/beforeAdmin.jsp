<%@page import="news.NewsInfo"%>
<%@page import="java.util.List"%>
<%@page import="news.Page"%>
<%@page import="news.BizDaoImp"%>
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
//在进入admin1.jsp页面之前要发送一个请求
BizDaoImp bdi =new BizDaoImp();
Page page1=new Page();
page1.setCurrentPage(1);
List<NewsInfo> list=bdi.fenYan(page1);
request.setAttribute("page1", page1);
request.setAttribute("list", list);
request.getRequestDispatcher("admin1.jsp").forward(request,response);
%>
</body>
</html>