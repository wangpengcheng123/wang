<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>������Ա-����</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">
</head>
<body>
		<table cellspacing="1" cellpadding="4" width="100%"
			class="tableborder" id="table3">
			<!-- <form name="form1" action="showUserList.jsp" method="post"> -->
			<tr>
				<td colspan="4" class="header"> 
					���Ź��� 
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>���ű���</b>
				</td>
				<td align="center" class="altbg1">
					<b>���ŷ���ʱ��</b>
				</td>
				<td align="center" class="altbg1">
					<b>�޸�</b>
				</td>
				<td align="center" class="altbg1">
					<b>ɾ��</b>
				</td>
			</tr>
			<c:if test="${allNews!=null}">
			<c:forEach items="${allNews}" var="n" step="1">
			
				<tr>
					<td align="center" class="altbg2">
						${n.ntitle }
					</td>
					<td class="altbg2" align="center">
						${n.ntime }
					</td>
					<td class="altbg2" align="center">
						<a href="#">�޸�</a>
					</td>
					<td class="altbg2" align="center">
						<a href="#">ɾ��</a>
					</td>
				</tr>
				
			</c:forEach>
			</c:if>
</body>
</html>