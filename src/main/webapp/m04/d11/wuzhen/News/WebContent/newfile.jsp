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
 request.setCharacterEncoding("utf-8");
 String name=request.getParameter("uname");
 String psw=request.getParameter("upwd");
 UserInfo ui=new UserInfo();
 ui.setName(name);
 ui.setPsw(psw);
 BizDaoImp bdi=new BizDaoImp();
 boolean flag=bdi.yanzheng(ui);
 Page page1=new Page();
 if(flag){
    session.setAttribute("name",name);   
    page1.setCurrentPage(1);
    List<NewsInfo> list=bdi.fenYan(page1);

     request.setAttribute("page1", page1); 
    request.setAttribute("list", list);
    request.getRequestDispatcher("admin1.jsp").forward(request,response);    
 }else{
     response.sendRedirect("index1.jsp");
 }

%>

</body>
</html>