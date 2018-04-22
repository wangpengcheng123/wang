<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a{
text-decoration: none;
color:blue;
}
</style>
</head>
<body>
 <% // 不读取缓存
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragrma","no-cache"); 
	response.setDateHeader("Expires",0); 
%>
<form action="login" method="post">
<table border="1px">
<tr>
<td>用户名</td>
<td><input type="text" name="user"/></td>
</tr>
<tr>
<td>密码</td>
<td><input type="password" name="pwd"/></td>
</tr>
<tr><th colspan="2"><input type="submit" value="登录"/></th></tr>
</table>
</form>
<table align="center" border="1px">
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>商品单价</th>
<th>商品描述</th>
<th>操作</th>
</tr>
<c:forEach items="${listPro}" var="l_pro">
<tr>
<td>${l_pro.spid}</td>
<td>${l_pro.spname}</td>
<td>${l_pro.spprice}</td>
<td>${l_pro.spdesc}</td>
<th><a href="show?id=${l_pro.spid}&client_token=${server_token}">加入购物车</a></th>
</tr>
</c:forEach>
</table>
</body>
</html>