<%@page import="com.dt59.service.impl.ImplBizService"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.UserInfo"%>
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
	request.setCharacterEncoding("utf-8");//设置编码
	String name = request.getParameter("name");//取用户名输入的值
	String pwd = request.getParameter("pwd");//取输入密码的值
	UserInfo ui = new UserInfo();//创建信息表的对象
	ui.setUsername(name);//传用户名值给信息表
	ui.setPassword(pwd);//传密码给信息表
	BizDaoImpl bd = new BizDaoImpl();
	ImplBizService ils = new ImplBizService();
	ils.setBd(bd);
	boolean f = ils.yanZheng(ui);
	if(f){
	    session.setAttribute("name", name);//储存用户名的值
	    request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	}else{
	    response.sendRedirect("index.jsp");
	}
%>
</body>
</html>