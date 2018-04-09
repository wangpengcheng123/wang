<%@page import="java.io.PrintWriter"%>
<%@ page import="news.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String id=request.getParameter("id");
String type=request.getParameter("ntid");
String ntitle=request.getParameter("ntitle");
String nauthor=request.getParameter("nauthor");
String nsummary=request.getParameter("nsummary");
String ncontent=request.getParameter("ncontent"); 
BizDaoImp bdi=new BizDaoImp();
NewsInfo ni=new NewsInfo();
ni.setType_id(Integer.valueOf(type));
ni.setTitle(ntitle);
ni.setName(nauthor);
ni.setSummary(nsummary);
ni.setContent(ncontent);
ni.setNews_id(Integer.valueOf(id));
int flag=bdi.insert(ni);
if(flag>0){
    PrintWriter pw=response.getWriter();
    pw.write("<script>");
    pw.write("alert('修改成功！');");
    pw.write("window.location.href='newfile.jsp?uname=admin&upwd=123'");
    pw.write("</script>");
    
   // response.sendRedirect("newfile.jsp?uname=admin&upwd=123");
    }else{
        response.sendRedirect("news_modify.jsp");
    }
%>
</body>
</html>