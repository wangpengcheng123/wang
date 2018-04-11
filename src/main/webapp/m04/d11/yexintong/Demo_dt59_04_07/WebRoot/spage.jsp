<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.Page"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'spage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<%
    		request.setCharacterEncoding("utf-8");
    		String currentpage= request.getParameter("currentpage");
    		Page page2=new Page();
    		page2.setCurrentpae(Integer.parseInt(currentpage));
    		//page2.setCurrentpae(2);
    		BizDaoImpl bdi=new BizDaoImpl();
    		BizServiceImpl bsi=new BizServiceImpl();
    		bsi.setBizDao(bdi);//注入
    		List<NewsInfo> list=bsi.getNews();
    		page2.setSumsize(list.size());
    		List<NewsInfo> listnews= bsi.getPagesInfo(page2);
    		//for(NewsInfo newsInfo:listnews){
    		//out.print(newsInfo.getNewstitle()+"\t"+newsInfo.getNewsauthor());
    		//}
    	
    		request.setAttribute("page2", page2);
    		request.setAttribute("listpage", listnews);
    		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);   	
    	 %>
  </body>
</html>
