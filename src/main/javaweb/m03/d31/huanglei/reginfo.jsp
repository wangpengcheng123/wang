<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
   		request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String[] channels=request.getParameterValues("channel");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div border="0" align="center">
			<tr>
				<td width="80" height="20">用户名:</td>
				<td><%=name %></td>
				<td width="80" height="20"></br>密码:</td>
				<td><%=pwd %></td>
			</tr>
			<tr>
				<td height="20"></br>信息来源:</td>
				<td>
					<%
					  if(channels!=null){
					      for(String channel:channels){
					          out.println(channel+"&nbsp;");
					      }
					  }
					%>
				</td>
			</tr>
		</div>
</body>
</html>