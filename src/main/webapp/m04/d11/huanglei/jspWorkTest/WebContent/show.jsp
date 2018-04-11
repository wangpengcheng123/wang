<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    
 
    标题:<%=session.getAttribute("title") %></br>
    作者:<%=session.getAttribute("uname") %></br> 
    摘要:<%=session.getAttribute("zhaiyao") %></br>
    内容:<%=session.getAttribute("neirong") %></br>
    图片素材:</br><img src="upload/<%=request.getAttribute("filename") %>"></br>

</body>
</html>