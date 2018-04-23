<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  src="JS/jquery-1.8.3.js" type="text/javascript" ></script>
<script  src="JS/json2.js" type="text/javascript" ></script>
<script type="text/javascript">




		$(function(){
			
			$("#myselect").change(function(){
				var uname=$(this).val();
				$.ajax({
					url:"ajax1",
					data:{"uname":uname},
					dataType:"json",
					Type:"POST",
					success:function(date){
						$("#mycity option").remove();//移除子节点
					for(var i=0;i<date.length;i++){
						for(var j=0;j<date[i].length;j++){
					var option="<option>"+date[i][j]+"</option>";
						$("#mycity").append(option);
							
						}
					}
					
					},
				    error:function(){
				    	alert("错误");
				    }
				})
			})
		})
</script>
</head>
<body>
<%
  response.setHeader("Cache-Control", "no-store");
  response.setHeader("Pragrma", "no-cache");
  response.setDateHeader("Expires", 0);
%>
 <!--  <input type="text" name="uname" id="uname"><div id="sp"></div><br>
  <input type="pwd" name="pwd"> -->
  <select id="myselect">
     <option value="湖北" class="uname">湖北</option>
     <option value="湖南" class="uname">湖南</option>
     <option value="广东" class="uname">广东</option>
    
  </select>
  <div id="sp"></div><br>
  
  
  
  
    <select id="mycity">
     
  </select>
</body>
</html>