<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示注册信息</title>
</head>
<body>
<%
request.setCharacterEncoding("utf8");
String user=request.getParameter("user");
String psw=request.getParameter("psw");
String check[]=request.getParameterValues("source");
%>
<table>
<tr><th>你输入的注册信息</th></tr>
<tr><td>用户名：&nbsp;&nbsp;<%=user%></td></tr>
<tr><td>密码：&nbsp;&nbsp;<%=psw%></td></tr>
<tr><td>信息来源：&nbsp;&nbsp;<% if(check!=null){
                   for(String option:check){
                    out.print(option+" ");
                   }
}
                   %></td></tr>
</table>
</body>
</html>