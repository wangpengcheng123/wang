<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>编号</th>
		<th>商品名称</th>
		<th>价格</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${listsp}" var="lisp">
	<tr>
		<td>${lisp.spid}</td>
		<td>${lisp.spname}</td>
		<td>${lisp.spprice}</td>
		<td>${lisp.spdesc}</td>
		<td><a href="<%=path %>/ShopPingServlet?id=${lisp.spid}&client_token=${server_token}">加入购物车</a></td>
	</tr>
	</c:forEach>
</table>

<form action="<%=path %>/YZuser" method="post">
用户名：<input type="text" name="uname"/>
密码：<input type="password" name="upwd"/>
<input type="submit" value="登陆"/>
</form>
</body>
</html>