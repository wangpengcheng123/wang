<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>

<title>Insert title here</title>
<c:if test="${!empty sess }">
<script type="text/javascript">
		alert("不能重复刷新页面！")
		window.location.href="<%=basePath%>/servlet/InitServlet";

</script>
</c:if>
<%session.setAttribute("sess", "sess"); %>
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
	table tr td a{
	text-decoration: none;
	}
</style>
<script type="text/javascript" src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function sumPrice(){
		$("input[name='number']").each(function(index,domEle){
			var num=parseInt($(domEle).val());
			var price=parseFloat($(".price:eq("+index+")").text());
			$("input[name='sumprice']:eq("+index+")").val(price*num);
			
		})
			
	}
	/*  function add(domEle){
		
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
	}  */
	function add(domEle,index){
		var number=parseInt($(domEle).prev().val())+1;
		
		$.post(
			"<%=basePath %>/servlet/AjaxShopping",
			{
				"number":number,
				"spid":index
			},
			function(data){
				/* alert(data.info); */
				
			},
			"json"
		);
		 $(domEle).prev().val(number);
		sumPrice(); 
		
	} 
	function jian(domEle,index){
		if(parseInt($(domEle).next().val())==1){
			return;
		}
		var number=parseInt($(domEle).next().val())-1;
		
		$.post(
				"<%=basePath %>/servlet/AjaxShopping",
				{
					"number":number,
					"spid":index
				},
				function(data){
					/* alert(data.info); */
					
				},
				"json"
			);
		$(domEle).next().val(number);
			sumPrice(); 
	}
	function lost(domEle,index){
		var number=parseInt($(domEle).val());
		if(number==0){
			number=1;
		}
		$.post(
				"<%=basePath %>/servlet/AjaxShopping",
				{
					"number":number,
					"spid":index
				},
				function(data){
					/* alert(data.info); */
					
				},
				"json"
			);
		$(domEle).val(number);
			sumPrice(); 
		
	}
	
	$(function(){
		sumPrice();
		
	})
</script>
</head>
<body>
	<table align="center" border="1px" cellpadding="0px" cellspacing="0px">
		<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<!--获取所有的收藏的数据  -->
		<c:forEach items="${sessionScope.MapSP }" var="mmp">
		<!--判断收藏的数据的键 即是用户的id，等于登陆的ID 在进行下一步  -->
			<c:if test="${mmp.key==sessionScope.uid }">
			<!-- 获取用户id等于登陆id用户收藏的商品信息，然后进行遍历 -->
				<c:forEach items="${mmp.value }" var="map">
		<tr>
			<td>${map.value.spid }</td>
			<td>${map.value.spname }</td>
			
			
			<td>
				<a href="javascript:void(0)" onclick="jian(this,${map.value.spid })">-</a>
				<input type="text" name="number" value="${map.value.number }" onblur="lost(this,${map.value.spid })">
				<a href="javascript:void(0)" onclick="add(this,${map.value.spid })">+</a> 
			</td> 
			
			<td><span class="price">${map.value.spprice }</span>元</td>
			<td>${map.value.spdesc }</td>
			<td><input type="text" name="sumprice" value=""></td>
			
			<td><a href="javascript:void(0)">购买</a></td>
		</tr>
			</c:forEach>
		</c:if>
	</c:forEach>
	
	</table>
	
</body>
</html>