<%@page import="news.NewsInfo"%>
<%@page import="java.util.List"%>
<%@page import="news.BizDaoImp"%>
<%@page import="news.Page"%>
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
 request.setCharacterEncoding("utf-8"); 
Page reqPage=new Page();
BizDaoImp bdi=new BizDaoImp();
int count=bdi.addTitle().size();
reqPage.setCurrentPage(Integer.valueOf(request.getParameter("currentPage")));
reqPage.setTotalPage(count%reqPage.getCountRec()==0?count/reqPage.getCountRec():count/reqPage.getCountRec()+1);
List<NewsInfo> list=bdi.fenYan(reqPage);
request.setAttribute("page1", reqPage);
request.setAttribute("list", list);
request.getRequestDispatcher("admin1.jsp").forward(request,response);
%>
</body>
</html>