<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=basePath %>/resources/js/jquery-1.8.3.js" type="text/javascript"></script>
	<script>
		$(function(){
			$("#uname").blur(function(){
				var uname=$(this).val();
				//alert(uname);
				$.ajax({
					url:"<%=basePath %>/ajax",
					type:"GET",
					data:"uname="+uname+"&index=0",
					dataType:"text",
					success:function(message){
						//成功后：回调函数
						$("#sp1").html(message);
					},
					error:function(){
						/* alert("ajax error!"); */
					}
				});
			});
			
			 $("#upwd").blur(function(){
					var upwd=$(this).val();
					$.ajax({
						url:"<%=basePath %>/ajax",
						typ:"GET",
						data:"upwd="+upwd+"&index=1",
						datatype:"text",
						success:function(message){
							$("#sp2").html(message);
						},
						error:function(){
							
						}
						
					});
					
				}); 
		});
		
	</script>
  </head>
  
  <body>
    <label>用户名：</label>
    <input type="text" id="uname" name="uname"/><span id="sp1" style="color:red;font-size:18px;"></span><br/>
     <label>密码：</label>
    <input type="text" id="upwd" name="upwd"/><span id="sp2" style="color:red;font-size:18px;"></span><br/>
  </body>
</html>