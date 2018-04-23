<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
	<style type="text/css">
			#div_body{
				height:100px;
				width:450px;
				margin:200px auto;
			}
			select{
			width:200px
			}
		
	</style>
	<script src="<%=basePath %>/resources/js/jquery-1.8.3.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function(){
		
	
		$("#select1").change(function(){
			var selectval=$("#select1").val();
			
			
			  $.post(
				"<%=basePath %>/servlet/SelectServlet",
				{
					"selectval":selectval
				},
				function(message){
					
					$("#select2 option").each(function(index,domEle){
						if(index!=0){
							$(domEle).remove();
						}
					});
					for(var i=0;i<message.length;i++){
						var $option=$("<option>"+message[i]+"</option>")
						
						$("#select2").append($option);
					}
					
				},
				"json"
			);	 
		});
	});
	</script>
</head>
<body>
<div id="div_body">
	<select name="city" id="select1">
		<option selected="selected">未知位置</option>
		<option value="1" >湖北</option>
		<option value="2">湖南</option>
		<option value="3">广东</option>
	
	</select>
	<select id="select2">
		<option selected="selected">未知位置</option>
	
	</select>
</div>
</body>
</html>