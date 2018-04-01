<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String pwd=request.getParameter("pwd");
	String[] check=request.getParameterValues("check");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 0px auto;">
		<form name="form1" method="post" action="reginfo.jsp">
				<table align="center">
					<tr align="center">
						<td colspan="2">你输入的注册信息</td>
					</tr>
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
						<td>
							<%
								if(check!=null){
								    for(String checks:check){
								        out.print(checks+"&nbsp;");
								    }
								}
							%>					
						</td>
					</tr>
				</table>
		</form>
	</div>
</body>
</html>