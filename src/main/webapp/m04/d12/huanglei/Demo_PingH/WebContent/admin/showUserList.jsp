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
		<table cellspacing="1" cellpadding="4" width="100%" class="tableborder" id="table3" align="center">
			<!-- <form name="form1" action="showUserList.jsp" method="post"> -->
			<tr>
				<td colspan="3" class="header">&nbsp; 
					�û����� 
				</td>
			</tr>
			<tr>
				<td align="center" class="altbg1">
					<b>�û���</b>
				</td>
				<td align="center" class="altbg1">
					<b>��ݴ���</b>
				</td>
				<td align="center" class="altbg1">
					<b>����</b>
				</td>
			</tr>
			<c:if test="${ulist!=null">
			<c:forEach items="${ulist}" var="u">
			<tr>
				<td align="center" class="altbg2">
					${u.uname }
				</td>
				<td class="altbg2" align="center">
					${u.ulevel }
				</td>
				<td class="altbg2" align="center">
					<a href="/fuchsin/deleUser?userID=${u.uid }" onclick="return window.confirm('ȷ��Ҫɾ�����û���')">ɾ��</a>
				</td>
			</tr>
			
			</c:forEach>
			</c:if>
			<!-- </form> -->
		</table>
</body>
</html>