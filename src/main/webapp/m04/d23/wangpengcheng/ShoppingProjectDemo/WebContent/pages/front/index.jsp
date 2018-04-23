<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
<% session.removeAttribute("sess"); %>
<% // 不读取缓存
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragrma","no-cache"); 
	response.setDateHeader("Expires",0); 
	%>
<style type="text/css">
	table{
		width:800px;
		height:auto;
		text-align: center;
		margin-top:200px
	}
	table tr{
		height:40px
	}
</style>

</head>
<body>
<table align="center" border="1px" cellpadding="0px" cellspacing="0px">
		<tr>
			<th>序号</th>
			<th>名称</th>
			<th>价格</th>
			<th>内容</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${listShangPing }" var="sp">
			<tr>
				<td>${sp.spid }</td>
				<td>${sp.spname }</td>
				<td>${sp.spprice }</td>
				<td>${sp.spdesc }</td>
				<td><a href="<%=basePath %>/servlet/AddShoppingServlet?spid=${sp.spid }">添加到购物车</a></td>
			</tr>
		
		</c:forEach>
 </table>
</body>
</html>