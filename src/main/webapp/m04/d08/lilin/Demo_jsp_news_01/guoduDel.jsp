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
	BizDaoImpl bdi = new BizDaoImpl();
	ImplBizService bsi = new ImplBizService();
	bsi.setBd(bdi);//注入
	request.setCharacterEncoding("utf-8");
	String id= request.getParameter("id");
	int flag=bsi.delNewsInfoById(Integer.valueOf(id));
	if(flag>0){
		response.sendRedirect("delone.jsp");
	}else{
		response.sendRedirect("deltwo.jsp");
	}
%>
</body>
</html>