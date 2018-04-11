<%@page import="com.dt59.entity.Page"%>
<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.dt59.service.impl.ImplBizService"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加主题--管理后台</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="Images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="Images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：<span id="sp"><%=session.getAttribute("name") %></span> 登录  &#160;&#160;&#160;&#160; <a href="index.html">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <div id="opt_list">
    <ul>
      <li><a href="news_add.html">添加新闻</a></li>
      <li><a href="admin.html">编辑新闻</a></li>
      <li><a href="topic_add.html">添加主题</a></li>
      <li><a href="topic_list.html">编辑主题</a></li>
    </ul>
  </div>
  <div id="opt_area">
    <!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	function del(id){
		//alert("del:"+id);
		window.location.href="guoduDel.jsp?id="+id;
	}
	function xg(id){
		window.location.href="admin/news_modify.jsp?id="+id;
	}
</script>
    <ul class="classlist">
     <%
     	BizDaoImpl bdi = new BizDaoImpl();
     	ImplBizService bsi = new ImplBizService();
     	bsi.setBd(bdi);//注入
     	List<NewsInfo> listnew = bsi.getNews();
     	
     	
     	List<NewsInfo> listnews = (List<NewsInfo>)request.getAttribute("listpage");
     	for(int i=0;i<listnews.size();i++){
			out.print("<li>"+listnews.get(i).getNewstitle()+"<span>作者:"+
		   			listnews.get(i).getNewsauthor()+"&#160;&#160;&#160;&#160; <a href='javascript:;' onclick='xg("+listnews.get(i).getNewsid()+");'>修改</a> &#160;&#160;&#160;&#160; "+
		   			"<a href='javascript:;' onclick='del("+listnews.get(i).getNewsid()+");'>删除</a> </span></li>");
			session.setAttribute("biaoti"+listnews.get(i).getNewsid(), listnews.get(i).getNewstitle());
			session.setAttribute("zuozhe"+listnews.get(i).getNewsid(), listnews.get(i).getNewsauthor());
			session.setAttribute("zhaiyao"+listnews.get(i).getNewsid(), listnews.get(i).getNewssummary());
			session.setAttribute("neir"+listnews.get(i).getNewsid(), listnews.get(i).getNewscontent()); 
		}
     %>
      <li class='space'></li>
      <%
      		Page pe = (Page)request.getAttribute("pe");
      %>
      <p align="center"> 
      <a href="shouyepage.jsp?currentpage=1">首页</a>&nbsp;&nbsp;&nbsp;  
      <a href="shouyepage.jsp?currentpage=<%=pe.getCurrentpage()+1 %>">下一页</a>&nbsp;&nbsp;&nbsp; 
      <a href="shouyepage.jsp?currentpage=<%=pe.getCurrentpage()-1 %>">上一页</a>&nbsp;&nbsp;&nbsp;
      <a href="shouyepage.jsp?currentpage=<%=listnew.size()/pe.getPagesize()+1 %>">尾页</a></p>
    </ul>
  </div>
</div>
<div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
</body>
</html>