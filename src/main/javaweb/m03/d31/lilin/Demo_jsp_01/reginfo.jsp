<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    		<%
				request.setCharacterEncoding("UTF-8");
				String name = request.getParameter("name");
				String pwd = request.getParameter("pwd");
				String[] channels = request.getParameterValues("channel");
			%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册信息</title>
</head>
<body>
		<div align="center">
			你输入的注册信息
			<table border="0" align="center">
				<tr>
					<td>用户名:</td>
					<td><%=name %></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><%=pwd %></td>
				</tr>
				<tr>
					<td>信息来源:</td>
					<td><%
							if(channels!=null){
							   for(String channel : channels){
							       out.print(channel+"&nbsp");
							   } 
							}
						%>
					</td>
				</tr>
			</table>
		</div>
</body>
</html>