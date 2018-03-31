<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("username");
	String pwd=request.getParameter("password");
	String[] info=request.getParameterValues("info");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册信息</title>
</head>
<body>
	<div align="center">
		你输入的注册信息
		<table>
			<tr>
				<td>用户名：</td>
				<td><%= name %></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><%= pwd %></td>
			</tr>
			<tr>
				<td>信息来源：</td>
				<td>
					<% 
						if(info!=null){
						    for(int i=0;i<info.length;i++){
						        out.print(info[i]+"&nbsp;");
						    }
						}
					%>
				
				</td>
			</tr>
		</table>
	
	</div>
</body>
</html>