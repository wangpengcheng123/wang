<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache,must-revalidate">
<meta http-equiv="expires" content="web,26 feb 1997 08:21:57 gmt">
<title>Insert title here</title>
<script type="text/javascript">
	/*  function abc(){
		 var tb=document.getElementById("tb");
		 var tt= tb.children;
		 for(var i=0;i<tt.length;i++){
			tt[i].children[5].children[0].value= tt[i].children[2].children[1].value*tt[i].children[3].children[0].value;
		 }
	 } */
	  window.onload=function(){

		 var add=document.getElementsByName("add");
		 for(var i=0;i<add.length;i++){
			add[i].onclick=function(){
				addd();
				var add=parseInt(this.parentNode.children[1].value);
				add++;
				this.parentNode.children[1].value=add;
				
			
			}
		 }
		 var jfs=document.getElementsByName("jfs");
		 for(var i=0;i<jfs.length;i++){
			jfs[i].onclick=function(){
				jff();
				var jfs=parseInt(this.parentNode.children[1].value);
				jfs--;
				if(jfs<=0){
					jfs=1;
				}
				 
				this.parentNode.children[1].value=jfs;
				
			}
		 }
			/* *************************Ajax*************************** */
			function jff() {
				
			    var xmlHttp;
		        try {
					// Firefox, Opera 8.0+, Safari
					xmlHttp = new XMLHttpRequest();
				} catch (e) {

					// Internet Explorer
					try {
						xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {

						try {
							xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {
							alert("您的浏览器不支持AJAX！");
							return false;
						}
					}
				}

				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4) {
						var zongjias=xmlHttp.responseText;
						document.getElementById("zongjia").value=zongs;
						//alert(zongs);
					}
				}
				var num=document.getElementById("num").value;
				var danjia=document.getElementById("danjia").value;
				var zongjia=document.getElementById("zongjia").value;
				var jf=1;
				xmlHttp.open("GET", "Ajax?num="+num+"&jf="+jf+"&danjia="+danjia+"&zongjia="+zongjia, true);
				xmlHttp.send(null);
				

			}
			function addd() {
				
			    var xmlHttp;
		        try {
					// Firefox, Opera 8.0+, Safari
					xmlHttp = new XMLHttpRequest();
				} catch (e) {

					// Internet Explorer
					try {
						xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {

						try {
							xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {
							alert("您的浏览器不支持AJAX！");
							return false;
						}
					}
				}

				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4) {
						var zongs=xmlHttp.responseText;
						document.getElementById("zongjia").value=zongs;
					
					}
				}
				var num=document.getElementById("num").value;
				var danjia=document.getElementById("danjia").value;
				var zongjia=document.getElementById("zongjia").value;
				var jf=2;
				xmlHttp.open("GET", "Ajax?num="+num+"&jf="+jf+"&danjia="+danjia+"&zongjia="+zongjia, true);
				xmlHttp.send(null);
			}
	 } 

</script>
</head>
<body>


	<input type="text" value="${uuid }" name="uuid1">
	<table border="1">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品数量</td>
			<td>商品价格</td>
			<td>商品评价</td>
			<td>总价</td>
			<td>操作</td>
		</tr>
		<tbody id="tb">
			<c:forEach items="${map }" var="ap">
				<tr>
					<td>${ap.value.spid }</td>
					<td>${ap.value.spname }</td>
					<td><a href="javascript:;" name="jfs" >-</a><input
						type="text" width="50px" readonly="readonly"
						value="${ap.value.num }" id="num"><a href="javascript:;"
						name="add" >+</a></td>
					<td><input type="text" width="50px" readonly="readonly"
						value="${ap.value.spprice }" id="danjia"></td>
					<td>${ap.value.spdesc  }</td>
					<td><input type="text" readonly="readonly" value="0"
						id="zongjia"></td>
					<td><a
						href="<%=path %>/Goumai?spid=${ap.value.spid }&spname=${ap.value.spname }&spnum=${ap.value.num }&spprice=${ap.value.spprice }&spdesc=${ap.value.spdesc  }&zongjia=${ap.value.spprice }">购买>></td>
				</tr>
			</c:forEach>
		</tbody>
		<tr style="height: 50px"></tr>


	</table>

</body>
</html>