<%@ page language="java" pageEncoding="gbk"%>
<html>

	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>����Ա-���</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">
		
		<script type="text/javascript">
		function fun_check_form(){
			if(document.form1.title.value==""){
				alert("���������ű�����Ϣ��");
				return false;
			}else if(document.form1.content.value==""){
				alert("��������������");
				return false;
			}else{
				return true;
			}
		}
		
		</script>
	</head>

	<body>
		<form name="form1" action="/fuchsin/addnews?isAdd=yes" method="post" onSubmit="return fun_check_form()">
			<table cellspacing="1" cellpadding="4" width="100%"
				class="tableborder" id="table3">

				<tr>
					<td colspan="12" class="header">
						���������Ϣ
					</td>
					<td><input type="hidden" name="nid"/></td><!-- Ϊ�޸�����ʱ�� -->
				</tr>
				<tr>
					<td class="altbg1">
						���ű��⣺
					</td>
					<td class="altbg2" colspan="11">
						<input type="text" name="title" size="34">
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						�������ݣ�
					</td>
					<td class="altbg2" colspan="11">
						<textarea rows="5" cols="60" name="content"></textarea>
					</td>
				</tr>
				

				<tr>
					<td class="altbg1">
					</td>
					<td class="altbg2" colspan="11">
						<input type="submit" value="�ύ" name="B1" />
						&nbsp;
						<input type="reset" value="����" name="B2" />
					</td>
				</tr>

			</table>
		</form>
	</body>

</html>
