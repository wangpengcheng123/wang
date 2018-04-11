<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.dt59.entity.Page"%>
<%@page import="com.dt59.service.impl.ImplBizService"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
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
	request.setCharacterEncoding("utf-8");//设置编码集
	String currentpage = request.getParameter("currentpage");//获取的当前页面
	
	Page pe = new Page();
	pe.setCurrentpage(Integer.parseInt(currentpage));//将获取的当前页赋值给Page类中
	request.setAttribute("pe", pe);	
	BizDaoImpl bd = new BizDaoImpl();
	ImplBizService ibs = new ImplBizService();
	ibs.setBd(bd);//注入
	List<NewsInfo> list = ibs.getNewsInfoByPage(pe);//将Page类传入
	request.setAttribute("listpage", list);
	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	
%>
</body>
</html>