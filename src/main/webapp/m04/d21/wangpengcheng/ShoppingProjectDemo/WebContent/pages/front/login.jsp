<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>

<title>Insert title here</title>
<style type="text/css">
	table{
		width:800px;
		height:auto;
		text-align: center;
		margin-top:200px;
	}
	table tr{
		height:40px;
	}
</style>
<script type="text/javascript" src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#submit").click(function(){
			var username=$("input[type='text']").val();
			var password=$("input[type='password']").val();
			$.post(
				"<%=basePath %>/servlet/LoginServlet",
				{
					"username":username,
					"password":password
				},
				function(data){
					var result=data.info;
					if(result==0){
						alert("用户名或密码错误！");
					}
					if(result==1){
						window.location.href="<%=basePath%>/servlet/InitServlet";
					}
				},
				"json"
			);
		});
	});

</script>
</head>
<body>
<form action="" method="post">
<table align="center" border="1px" cellpadding="0px" cellspacing="0px">
		<tr>
			<th colspan="2">登陆</th>
			
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" required="required"/></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="password" required="required"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="登陆" id="submit"/></td>
		</tr>
 </table>
 </form>
</body>
</html>