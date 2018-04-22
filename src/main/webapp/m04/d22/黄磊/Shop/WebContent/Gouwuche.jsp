<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">



window.onload=function bcd(){

 
var result=document.getElementById("result");
var denglu=document.getElementById("denglu");
var flag=document.getElementById("flag");
var yidenglu=document.getElementById("yidenglu");
 flag.style.display="none"; 
yidenglu.style.display="none";
if(flag.value!="true"){
	alert("尚未登录,请登录后再购物");
	denglu.style.display="block";
}
if(flag.value=="true"){
	denglu.style.display="none";
	result.style.display="none";
	yidenglu.style.display="block";
	
	
	 }
	


}




</script>
</head>
<%
  response.setHeader("Cache-Control", "no-store");
  response.setHeader("Pragrma", "no-cache");
  response.setDateHeader("Expires", 0);
%>
<body>
        <table border="1">
           <tr>
           		<td>商品编号</td>
           		<td>商品名称</td>
           		
           		<td>商品价格</td>
           		<td>商品评价</td>
           		<td>操作</td>
           </tr>
          
         <c:forEach items="${listshangping }" var="sp">
           <tr>
                <td name="id">${sp.spid }</td>
           		<td>${sp.spname }</td>
           		
           		<td>${sp.spprice }</td>
           		<td>${sp.spdesc }</td>
           		<td><a href="<%=path %>/AddShop?id=${sp.spid }&panduan=${flag }&uuid=${uuid }" >加入购物车>></td>
           </tr>
       </c:forEach>
       <tr style="height: 50px"></tr>
       </table>
       <table>
       <tr>
       <td><input type="text" readonly="readonly" name="flag1" id="flag" value="${flag }"></td>
       <td><input type="text" readonly="readonly" value="用户未登录，请登录后购物" id="result"/></td>
       <td><a href="UserPass.jsp"  id="denglu">登录</td>
       <td><input type="text" readonly="readonly" value="用户：${username }已登录！" id="yidenglu"/></td>
       </tr>
       </table>
</body>
</html>