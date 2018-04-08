<%@page import="com.dt59.service.impl.ImplBizService"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.NewsInfo"%>
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
	/* BizDaoImpl bdi = new BizDaoImpl();
	ImplBizService bsi = new ImplBizService();
	bsi.setBd(bdi);//注入
	request.setCharacterEncoding("utf-8");
	String id= request.getParameter("id"); */
	//String str = (String)session.getAttribute("id");
	String str="14";
	int a = 14;
	String ntitle = request.getParameter("ntitle");
	String nauthor = request.getParameter("nauthor");
	String nsummary = request.getParameter("nsummary");
	String ncontent = request.getParameter("ncontent");
	NewsInfo ni = new NewsInfo();
	//ni.setNewsid(Integer.parseInt(str));
	ni.setNewsid(a);
	ni.setNewstitle(ntitle);
	ni.setNewsauthor(nauthor);
	ni.setNewssummary(nsummary);
	ni.setNewscontent(ncontent);
	BizDaoImpl bd = new BizDaoImpl();
	int flag = bd.xgInfoNews(ni);
	if(flag>0){
	    out.println("修改成功！");
	}else{
	    out.println("修改失败！");
	}
%>
</body>
</html>