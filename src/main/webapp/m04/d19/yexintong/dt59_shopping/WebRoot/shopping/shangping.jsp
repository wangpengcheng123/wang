<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="CSS/shangping.css">
  </head>
  <body>
  	<div id="denglu">
	  	<form action="denglu" method="post">
	  		用户名：<input type="text" name="user" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  		密码：<input type="password" name="pwd"/>&nbsp;&nbsp;&nbsp;
	  		<input type="submit" value="登录"/>
	  	</form> 
  	</div>
	  <div id="shangping" align="center">  
	  	<table cellspacing="2" border="1px">
	  		<tr>
	  			<th>商品编号</th>
	  			<th>商品名称</th>
	  			<th>商品价格</th>
	  			<th>商品介绍</th>
	  			<th>操作</th>
	  		</tr>
	  		<c:forEach items="${shangpingall }" var="s">
	  			<tr>	
	  				<td>${s.spid }</td>
	  				<td>${s.spname }</td>
	  				<td>${s.spprice }</td>
	  				<td>${s.spdesc }</td>
	  				<td><a href="<%=path %>/addServlet?name=${name }&pid=${s.spid}">加入购物车</a></td>
	  			</tr>	  	
	  		</c:forEach>	  	
	  	</table>
	  </div>
  </body>
</html>
