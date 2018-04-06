
<%@ page import="news.*" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
 //request.setCharacterEncoding("utf-8");
 String name=request.getParameter("username");
 String psw=request.getParameter("upwd");
 UserInfo ui=new UserInfo();
 ui.setName(name);
 ui.setPsw(psw);
 BizDaoImp bdi=new BizDaoImp();
 boolean flag=bdi.yanzheng(ui);
    if(flag){
    session.setAttribute("name",name);
    request.getRequestDispatcher("admin1.jsp").forward(request,response);    
 }else{
     response.sendRedirect("index1.jsp");
 }
%>

</body>
</html>