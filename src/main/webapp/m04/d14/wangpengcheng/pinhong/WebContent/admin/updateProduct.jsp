<%@ page language="java" pageEncoding="gbk" isELIgnored="false"%>
<html>

	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>����Ա-���</title>
		<link rel="stylesheet" type="text/css" href="../css/style_admin.css">

	</head>

	<body>
		<form name="form1" action="/fuchsin/addProd?isupdate=yes" method="post" enctype="multipart/form-data" application/x-www-form-urlencoded" onSubmit="return fun_check_form()">
			<table cellspacing="1" cellpadding="4" width="100%"  align="left" class="tableborder" id="table3">

				<!-- <input type="hidden" name="action" value="update" /> -->
				<tr>
					<td colspan="12" class="header">
						������Ʒ��Ϣ
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						��Ʒ��ţ�
					</td>
					<td class="altbg2">
						<input type="text" name="pid" size="34" readonly="readonly" value="${prdInf.pid }" />
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						��Ʒ���ƣ�
					</td>
					<td class="altbg2">
						<input type="text" name="name" size="34" value="${prdInf.pname }"" />
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						��Ʒ�̱꣺
					</td>
					<td class="altbg2">
						<input type="text" name="brand" size="34" value="${prdInf.pbrand }" />
					</td>
				</tr>	
				<tr>
					<td class="altbg1">
						��Ʒ�ͺţ�
					</td>
					<td class="altbg2">
						<input type="text" name="type" size="34" value="${prdInf.ptype }" />
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						��Ʒ�۸�
					</td>
					<td class="altbg2">
						<input type="text" name="price" size="34" value="${prdInf.price }" />
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						��ƷͼƬ��
					</td>
					<td class="altbg2">			
						<img src="image/${prdInf.pimg}" id="mypic" border="0" height="50" width="80" align="bottom"/>
						<input type="file" size="10" name="pimg"  onchange="mypic.src=this.value" />
						<!-- ����Ĭ��·�� -->
						<input type="hidden" name="picture" value="${prdInf.pimg }" />
					</td>
				</tr>
				<tr>
					<td class="altbg1">
						��Ʒ���ܣ�
					</td>
					<td class="altbg2">
						<textarea rows="5" cols="60" name="remark" >${prdInf.premark }</textarea>
					</td>
				</tr>
				

				<tr>
					<td class="altbg1">
					</td>
					<td class="altbg2">
						<input type="submit" value="�ύ" name="B1" onclick="return fun_check_form()" />
						&nbsp;
						<input type="reset" value="����" name="B2" />
					</td>
				</tr>

			</table>
		</form>
	</body>

</html>
