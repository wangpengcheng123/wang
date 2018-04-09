<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="com.dt59.service.impl.ImplBizService"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加主题--管理后台</title>

<%
        BizDaoImpl bdi = new BizDaoImpl();
    	ImplBizService bsi = new ImplBizService();
    	bsi.setBd(bdi);//注入
    	request.setCharacterEncoding("utf-8");
    	String id= request.getParameter("id");
    	int a = Integer.valueOf(id);
    	session.setAttribute("id", a);
        %>
        
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />
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
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="index.html">login out</a></div>
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
    <h1 id="opt_type"> 修改新闻： </h1>
    <form action="../xgguodu.jsp" method="post" onsubmit="return check()" >
      <p>
        <label> 主题 </label>
        <select name="ntid">
        	<option value='1'>国内</option>
		<option value='2'>国际</option>
		<option value='3'>娱乐</option>       
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" class="opt_input"  value="<%=session.getAttribute("biaoti"+a) %>"/>
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" class="opt_input" value="<%=session.getAttribute("zuozhe"+a) %>" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" cols="40" rows="3" ><%=session.getAttribute("zhaiyao"+a) %></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" cols="70" rows="10" ><%=session.getAttribute("neir"+a) %></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input" />
      </p>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
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