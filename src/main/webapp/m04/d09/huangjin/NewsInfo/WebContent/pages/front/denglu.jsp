<%@page import="com.java.entity.CommentInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.java.service.impl.NewsServiceImpl"%>
<%@page import="com.java.service.NewsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html >
<html>
<head>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
<%-- <jsp:forward page="/servlet/ShouYeServlet"></jsp:forward> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中国</title>
<link href="<%=basePath %>/resources/CSS/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script>
<script language="javascript" type="text/javascript">

<%-- function login(){
	window.location.href="<%=basePath %>/pages/admin/admin.jsp";
} --%>
<%-- window.onload=function(){
	window.location.href="<%=basePath %>/servlet/ShouYeServlet";
} --%>
<%--function fun(){
	$.get(
		"<%=basePath %>/servlet/ShouYeServlet",
		{
			"start":"开始"
		},
		function(result){
			for(var i=0;i<result.size(),i++){
				
			}
		},
	
		"json"
	); --%>
}
</script>
<%
 NewsService news = new NewsServiceImpl();
List<CommentInfo> list = news.selectCommentDemo();

%>
</head>
<body>
<div id="header">
  <div id="top_login">
  <form action="<%=basePath %>/servlet/LoginServlet" method="post">
    <label> 登录名 </label>
    <input type="text" id="uname" name="userName" value="" class="login_input" />
    <label> 密&#160;&#160;码 </label>
    <input type="password" id="upwd" name="passWord" value="" class="login_input" />
    <input type="submit" class="login_sub" value="登录" /><!-- onclick="login()" -->
    </form>
    <label id="error"> </label>
    <img src="<%=basePath %>/resources/Images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  <div id="nav">
    <div id="logo"> <img src="<%=basePath %>/resources/Images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="<%=basePath %>/resources/Images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="<%=basePath %>/resources/Images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> 重庆涉黑富豪黎强夫妇庭审答辩言辞相互矛盾 </b></a> </li>
        <li> <a href='#'><b> 发改委：4万亿投资计划不会挤占民间投资空间 </b></a> </li>
        <li> <a href='#'><b> 河南2个乡镇政绩报告内容完全一致引关注 </b></a> </li>
      </ul>
    </div>
    <h1> <img src="<%=basePath %>/resources/Images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> 日本首相鸠山首次全面阐述新政府外交政策 </b></a> </li>
        <li> <a href='#'><b> 黎巴嫩以色列再次交火互射炮弹 </b></a> </li>
        <li> <a href='#'><b> 伊朗将于30日前就核燃料供应方案作出答复 </b></a> </li>
        <li> <a href='#'><b> 与基地有关组织宣称对巴格达连环爆炸负责 </b></a> </li>
      </ul>
    </div>
    <h1> <img src="<%=basePath %>/resources/Images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> 施瓦辛格启动影视业回迁计划 推进加州经济复苏 </b></a> </li>
        <li> <a href='#'><b> 《沧海》导演回应观众质疑 自信能超越《亮剑》 </b></a> </li>
        <li> <a href='#'><b> 《海角七号》导演新片开机 吴宇森等出席 </b></a> </li>
        <li> <a href='#'><b> 《四大名捕》敦煌热拍 八主演飙戏火花四溅 </b></a> </li>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="<%=basePath %>/resources/Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
        <li id='class_month'> <a href='#'><b> 国内 </b></a> <a href='#'><b> 国际 </b></a> <a href='#'><b> 军事 </b></a> <a href='#'><b> 体育 </b></a> <a href='#'><b> 娱乐 </b></a> <a href='#'><b> 社会 </b></a> <a href='#'><b> 财经 </b></a> <a href='#'><b> 科技 </b></a> <a href='#'><b> 健康 </b></a> <a href='#'><b> 汽车 </b></a> <a href='#'><b> 教育 </b></a> </li>
        <li id='class_month'> <a href='#'><b> 房产 </b></a> <a href='#'><b> 家居 </b></a> <a href='#'><b> 旅游 </b></a> <a href='#'><b> 文化 </b></a> <a href='#'><b> 其他 </b></a> </li>
      </ul>
      <ul class="classlist">
      
      	<% for(int i=0;i<list.size();i++){
      	    CommentInfo commentInfo=list.get(i);
      	   pageContext.setAttribute("commentInfo", commentInfo);
      
      %>
        <li><a href='newspages/news_add.html'> ${commentInfo.content }</a><span> ${commentInfo.date } </span></li>
    	
      <% 	} %>
       
        
        <li class='space'></li>
        <% for(int i=0;i<list.size();i++){
      	    CommentInfo commentInfo=list.get(i);
      	   pageContext.setAttribute("commentInfo", commentInfo);
      
      %>
        <li><a href='newspages/news_add.html'> ${commentInfo.content }</a><span> ${commentInfo.date } </span></li>
    	
      <% 	} %>
      
      <li class='space'></li>
        <% for(int i=0;i<list.size();i++){
      	    CommentInfo commentInfo=list.get(i);
      	   pageContext.setAttribute("commentInfo", commentInfo);
      
      %>
        <li><a href='newspages/news_add.html'> ${commentInfo.content }</a><span> ${commentInfo.date } </span></li>
    	
      <% 	} %>
      
        <li class='space'></li>
        
        <% for(int i=0;i<list.size();i++){
      	    CommentInfo commentInfo=list.get(i);
      	   pageContext.setAttribute("commentInfo", commentInfo);
      
      %>
        <li><a href='newspages/news_add.html'> ${commentInfo.content }</a><span> ${commentInfo.date } </span></li>
    	
      <% 	} %>
        <li class='space'></li>
        
        <% for(int i=0;i<list.size();i++){
      	    CommentInfo commentInfo=list.get(i);
      	   pageContext.setAttribute("commentInfo", commentInfo);
      
      %>
        <li><a href='newspages/news_add.html'> ${commentInfo.content }</a><span> ${commentInfo.date } </span></li>
    	
      <% 	} %>
        <li class='space'></li>
        <% for(int i=0;i<list.size();i++){
      	    CommentInfo commentInfo=list.get(i);
      	   pageContext.setAttribute("commentInfo", commentInfo);
      
      %>
        <li><a href='newspages/news_add.html'> ${commentInfo.content }</a><span> ${commentInfo.date } </span></li>
    	
      <% 	} %>
      <p align="right"> 当前页数:[1/2]&nbsp; <a href="#">下一页</a> <a href="#">末页</a> </p>
      </ul>
    </div>
    <div class="picnews">
      <ul>
        <li> <a href="#"><img src="<%=basePath %>/resources/Images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
        <li> <a href="#"><img src="<%=basePath %>/resources/Images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
        <li> <a href="#"><img src="<%=basePath %>/resources/Images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
        <li> <a href="#"><img src="<%=basePath %>/resources/Images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
      </ul>
    </div>
  </div>
</div>
<div id="friend">
  <h1 class="friend_t"> <img src="<%=basePath %>/resources/Images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
    文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    新闻中国 版权所有 </p>
</div>
</body>
</html>