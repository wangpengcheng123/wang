<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<%-- <%=request.getAttribute("path")%>
 --%>
标题：<%=session.getAttribute("ntitle") %><br/>
作者：<%=session.getAttribute("nauthor") %><br/>
摘要：<%=session.getAttribute("nsummary") %><br/>
内容：<%=session.getAttribute("ncontent") %><br/>
<img src="upload/<%=request.getAttribute("fileName") %>" width="300px" height="300px"/>
</h1>
</body>
</html>