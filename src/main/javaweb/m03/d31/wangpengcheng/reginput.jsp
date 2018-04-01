<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学员注册</title>
</head>
<body>
	<div style="margin: 0px auto;">
		<form name="form1" method="post" action="reginfo.jsp">
				<table align="center">
					<tr align="center">
						<td colspan="2">请输入注册信息</td>
					</tr>
					<tr>
						<td>用户名:</td>
						<td><input type="text" name="name"/></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="pwd"/></td>
					</tr>
					<tr>
						<td>信息来源:</td>
						<td><input type="checkbox" name="check" value="报刊"/>报刊
							<input type="checkbox" name="check" value="网络"/>网络
							<input type="checkbox" name="check" value="朋友推荐"/>朋友推荐
							<input type="checkbox" name="check" value="电视"/>电视					
						</td>
					</tr>
					<tr align="center">
						<td colspan="2">
						<input type="submit" name="submit" value="提交"/>
						<input type="reset" name="reset" value="取消"/>
						</td>
					</tr>
				</table>
		</form>
	</div>
</body>
</html>