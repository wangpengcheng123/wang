<%@ page language="java" pageEncoding="gbk"%>
<html>

	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>����Ա-���</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">
	</head>

	<body>
		<form action="/fuchsin/addmanager?isManager=yes" method="post">
			<table cellspacing="1" cellpadding="4" width="100%"
				class="tableborder" id="table3">

				<!-- <input type="hidden" name="action" value="save" />--> 
				<tr>
					<td colspan="12" class="header">
						����Ա-���
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						����Ա���ƣ�
					</td>
					<td class="altbg2" colspan="11">
						<input type="text" name="userName" size="34">
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						��&nbsp; �룺
					</td>
					<td class="altbg2" colspan="11">
						<input type="password" name="password" size="34">
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						ȷ�����룺
					</td>
					<td class="altbg2" colspan="11">
						<input name="confirmpassword" size="34" type="password">
					</td>
				</tr>


				<tr>
					<td class="altbg1">
					</td>
					<td class="altbg2" colspan="11">
						<input type="submit" value="�ύ">
						&nbsp;
						<input type="reset" value="����">
					</td>
				</tr>

			</table>
		</form>
	</body>

</html>
