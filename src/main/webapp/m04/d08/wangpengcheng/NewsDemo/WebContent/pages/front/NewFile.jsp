<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#mydiv{
width:300px;
height:300px;
border:1px solid red;

}
</style>
<script type="text/javascript" src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script>
<script language="javascript" type="text/javascript">

<%-- function login(){
	window.location.href="<%=basePath %>/pages/admin/admin.jsp";
} --%>
<%-- window.onload=function(){
	window.location.href="<%=basePath %>/servlet/ShouYeServlet";
} --%>
$(function(){ 
$("#mydiv").click(function(){
	
	
	$.get(
		"<%=basePath %>/servlet/ShouYeServlet",
		{
			"start":"开始"
		},
		/*这种是遍历json中是集合中嵌套集合  */
		/* function(result){
			for(var i=0;i<result.length;i++){
				for(var j=0;j<result[i].length;j++){
				var commentInfo=result[i][j];
			$("#mydiv").append("<li>"+commentInfo.username+"</li>");
				}
			}
		},	 */
		/* 这种是遍历json集合的情况 */
		function(result){
			for(var i=0;i<result.length;i++){
				
				var commentInfo=result[i]；
			$("#mydiv").append("<li>"+commentInfo.username+"</li>");
				
			}
		},	
		
		"json"
	);
});

});

</script>
</head>
<body onload="fun()">
<div id="mydiv"></div>
</body>
</html>