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
    
    <title>My JSP 'gouwuche.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="CSS/shangping.css">
	<style type="text/css">
		#shangping table tr th{
			width:150px;
		}
		a{
			text-decoration: none;
		}
	</style>
	<script type="text/javascript" src="<%=basePath%>/JavaScript/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	function sumPrice(){
		$("input[name='number']").each(function(index,domEle){
			var num=parseInt($(domEle).val());
			var price=parseFloat($(".price:eq("+index+")").text());
			$("input[name='sumprice']:eq("+index+")").val(price*num);
			
		});
			
	}
	 function add(domEle){
		
		var number=parseInt($(domEle).prev().val())+1;
		$(domEle).prev().val(number);
		sumPrice();
		
	}
	function jian(domEle){
		if(parseInt($(domEle).next().val())==1){
			return;
		}
		var number=parseInt($(domEle).next().val())-1;
		
		$(domEle).next().val(number);
		sumPrice();
	} 
	$(function(){
		sumPrice();
		
	})
</script>
  </head>
  
  <body>
      <div id="shangping" align="center">  
	  	<table cellspacing="2" border="1px">
	  		<tr>
	  			<th>商品编号</th>
	  			<th>商品名称</th>
	  			<th>商品数量</th>
	  			<th>商品价格</th>
	  			<th>商品介绍</th>
	  			<th>小计</th>
	  			<th>操作</th>
	  		</tr> 	
	  		<c:forEach items="${addMap.keySet() }" var="key">
		  		<c:forEach items="${addMap.get(key) }" var="a">
			  		<tr>
			  			<th>${a.spid }</th>
			  			<th>${a.spname }</th>
			  			<th><a href="javascript:void(0)" onclick="add(this)">+</a><input type="text" name="number" size="1"  value="${num }"><a href="javascript:void(0)" onclick="jian(this)">-</a></th>
			  			<th class="price">${a.spprice }&nbsp;&nbsp;元</th>
			  			<th>${a.spdesc }</th>
			  			<th><input type="text" name="sumprice" value=""></th>
			  			<th><a href="javascript:void(0)">购买</a></th>
			  		</tr> 	
		  		</c:forEach>
	  		</c:forEach>
	  	</table>
	  </div>
  </body>
</html>
