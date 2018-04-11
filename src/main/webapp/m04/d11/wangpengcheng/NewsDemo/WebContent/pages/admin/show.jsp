<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#mydiv{
font-size:30px;
color:red;
}
</style>
</head>
<body>
<div id="mydiv">
<%=request.getAttribute("title") %><br/>
<%=request.getAttribute("nauthor") %><br/>
<%=request.getAttribute("nsummary") %><br/>
<%=request.getAttribute("ncontent") %><br/>
<%=request.getAttribute("fileName") %><br/>
<%=request.getAttribute("path") %><br/>
<img alt="aa" src="../upload/<%=request.getAttribute("fileName") %>">
</div>

</body>
</html>