<%@page import="org.apache.commons.dbutils.handlers.BeanListHandler"%>
<%@page import="com.java.entity.NewsDemo"%>
<%@page import="com.java.utils.C3P0Utils"%>
<%@page import="org.apache.commons.dbutils.QueryRunner"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.entity.CommentInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.java.utils.JndiUtils"%>
<%@page import="java.sql.Connection"%>
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
Connection connection = JndiUtils.getConnection();
String sql = "SELECT * FROM `comment_info`";
PreparedStatement pStatement = null;
ResultSet resultSet = null;
List<CommentInfo> list = new ArrayList<CommentInfo>();

    pStatement = connection.prepareStatement(sql);
    resultSet = pStatement.executeQuery();
    while (resultSet.next()) {
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setComment_id(resultSet.getInt(1));
        commentInfo.setUsername(resultSet.getString(2));
        commentInfo.setIp(resultSet.getString(3));
        commentInfo.setContent(resultSet.getString(4));
        commentInfo.setNews_id(resultSet.getInt(5));
        commentInfo.setDate(resultSet.getDate(6));

        list.add(commentInfo);
 
    }
    
for (CommentInfo commentInfo : list) {
    out.println(commentInfo.getComment_id() + "\t" + commentInfo.getContent());
}



%>
<%
QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
String sql2 = "SELECT * FROM news_info";
List<NewsDemo> list2 = null;

    list2 = queryRunner.query(sql2, new BeanListHandler<NewsDemo>(NewsDemo.class));
    for (NewsDemo newsDemo : list2) {
        out.println(newsDemo.getNews_title()+"\t"+newsDemo.getNews_author());
    }



%>
</body>
</html>