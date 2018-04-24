<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
<script>
	$(function(){
		$("#uname").blur(function(){
			var uname=$("#uname").val();
			$.ajax({
				url:"AjaxServlet",
				type:"get",
				data:"uname"+uname,
				datatype:"text",
				succcess:function(message){
					$("#sp1").html(message);
				},
				error:function(){
					alert("ajax错误");
				}
			});
		});
	});
</script>
</head>
<body>
	<label>用户名：</label>
	<input type="text" name="uname" id="uname"/>
	<span id="sp1" style="color:red;font-size:18px;"></span><br/>
	<label>密码：</label>
	<input type="password" name="upwd" id="upwd"/>
</body>
</html>