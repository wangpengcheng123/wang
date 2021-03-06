<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加主题--管理后台</title>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
<link href="<%=basePath %>/resources/CSS/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="<%=basePath %>/resources/Images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="<%=basePath %>/resources/Images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：<span>${sessionScope.userName }</span>   &#160;&#160;&#160;&#160; <a href="<%=basePath %>/resources/index.html">login out</a></div>
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
   
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
    <ul class="classlist">
    <c:forEach items="${listNews }" var="news">
      <li>${news.news_title } <span> 作者：
        ${news.news_author }                                           
        &#160;&#160;&#160;&#160; <a href="<%=basePath %>/pages/admin/news_modify2.jsp?title=${news.news_title }&author=${news.news_author}&summary=${news.news_summary}&content=${news.news_content}&newsId=${news.news_id}">修改</a>
         &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
        
        </c:forEach>
      
      
        
        <li class='space'></li>
      <p align="right">
      <a href="<%=basePath %>/servlet/PageServlet?currpage=1">首页</a>
      <c:if test="${pageDemo.currpage==1 }">
      <a href="javascript:void(0)">上一页</a> 
      </c:if>
      <c:if test="${pageDemo.currpage!=1 }">
      <a href="<%=basePath %>/servlet/PageServlet?currpage=${pageDemo.currpage-1 }">上一页</a> 
      </c:if>
      
       
      当前页数:[${pageDemo.currpage }/${pageDemo.countpage }]&nbsp; 
       <c:if test="${pageDemo.currpage==pageDemo.countpage }">
      <a href="javascript:void(0)">下一页</a> 
      </c:if>
      <c:if test="${pageDemo.currpage!=pageDemo.countpage  }">
      <a href="<%=basePath %>/servlet/PageServlet?currpage=${pageDemo.currpage+1 }">下一页</a> 
      </c:if>
      
      
      <a href="<%=basePath %>/servlet/PageServlet?currpage=${pageDemo.countpage}">末页</a> </p>
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