<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员注册</title>
</head>
<body>
<form action="reginfo.jsp" method="post">
<table border="1px">
<tr>
<th colspan="2"><h2>请输入注册信息</h2></th>
</tr>
<tr>
<td>用户名：</td>
<td><input type="text" name="user" /></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password" name="psw"/></td>
</tr>
<tr>
<td>信息来源：</td>
<td>
<input type="checkbox" name="source" value="报刊"/>报刊
<input type="checkbox" name="source" value="网络"/>网络
<input type="checkbox" name="source" value="朋友推荐"/>朋友推荐
<input type="checkbox" name="source" value="电视"/>电视
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
<input type="reset" value="取消"/></td>
</tr>
</table>
</form>
</body>
</html>