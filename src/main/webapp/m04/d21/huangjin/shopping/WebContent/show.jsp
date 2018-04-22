<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a{
color:blue;
border:1px solid black;
}

</style>
<script src="js/jquery-1.8.3.js"></script>
<script>
function abc(){
	var tby=document.getElementById("tbody");
	var tt= tby.children;
	for(var i=0;i<tt.length;i++){				
		tt[i].children[5].innerHTML=tt[i].children[3].children[1].value*tt[i].children[2].innerHTML;
}
}
 $(function(){	 
	 abc();
   $(".des").click(function(){
    	var num=$(this).next().val();  	
    	num--;
    	if(num<1){
    		num=1;
    	}
    	$(this).next().val(num); ;
    	 abc(); 
    });
   $(".add").click(function(){
   	var num=$(this).prev().val();  	
   	num++;
   	$(this).prev().val(num); ;
   	 abc(); 
   });
  
}); 

</script>
</head>
<body>
<table border="1px" align="center">
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>商品单价</th>
<th>商品数量</th>
<th>商品描述</th>
<th>小计</th>
<th>操作</th>
</tr>
<tbody id="tbody">
<c:forEach items="${map }" var="m">

<tr>
<td>${m.value.spid}</td>
<td>${m.value.spname}</td>
<td>${m.value.spprice}</td>
<td><a href="javascript:;" class="des">-</a><input type="text" value="${m.value.amount}" name="num" class="num"/><a href="javascript:;" class="add">+</a></td>
<td>${m.value.spdesc}</td>
<td></td>
<td><a href="buylist?id=${m.value.spid}&name=${m.value.spname}&price=${m.value.spprice}&num=${m.value.amount}&desc=${m.value.spdesc}" class="buy">购买</a></td>
</tr>

</c:forEach>
</tbody>
</table>
</body>
</html>