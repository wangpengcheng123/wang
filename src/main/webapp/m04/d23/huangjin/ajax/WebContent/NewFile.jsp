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
<title>jquery+ json实现省市二级联动</title>
<script src="js/jquery-1.8.3.js"></script>
<script>
	$(function(){
		$("#s1").change(function(){
			//1.获取select框对象的值
			var val=("#s1").val();
			//获取选择的对象
			var opt=$("#s1 option:selected");
			
			var name=opt.text;
			$.ajax({
				"url":"CityServlet",
				"data":"name="+name,
				"type":"post",
				"success":function(msg){
					alert(msg);
					//清空下拉列表框
					$("#s2").empty();
					//遍历数组
					$.each(msg,function(i,text){
						alert("数组索引："+i);
						alert("数组的值："+text);
						//增加option
						$("#s2").append("<option>"+text+"</option>");
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<p align="center">jquery+ json实现省市二级联动</p>
	<table align="center">
		<tr>
			<td>请选择</td>
			<td><select id="s1">
					<option value="1">省份</option>
					<option value="2">湖北</option>
					<option value="3">湖南</option>
			</select></td>
			<td><select id="s2">
					<option>城市</option>
			</select></td>
		</tr>
	</table>
</body>
</html>