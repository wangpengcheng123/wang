<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	 var code;
    function createCode(){
        //����Ĭ��codeΪ���ַ���
        code = '';
        //���ó��ȣ����￴����������������4
        var codeLength = 4;
        var codeV = document.getElementById('code');
        //��������ַ�
        var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
        //ѭ��codeLength �����õ�4����ѭ��4��
        for(var i = 0; i < codeLength; i++){
            //�����������Χ,������Ϊ0 ~ 36
             var index = Math.floor(Math.random()*36);
             //�ַ���ƴ�� ��ÿ��������ַ� ����ƴ��
             code += random[index]; 
        }
        //��ƴ�Ӻõ��ַ�����ֵ��չʾ��Value
        //codeV.value = code;
        document.getElementById("cd").value=code;
    }
</script>
<html>
	<link href="css/right.css" rel="stylesheet" type="text/css" />
	<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
		<form action="<%=path %>/ServletUser1" method="post" target="_parent">
			<table width="399" border="0" align="center" cellpadding="0"
				cellspacing="0" bordercolor="#EBEBEB">
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr align="left">
					<td height="35" colspan="2" bgcolor="#EAF0FB" class="p16">
						<div align="center">
							<span class="d6"><strong>�� �� Ա �� ¼ </strong> </span>
						</div>
					</td>
				</tr>
				<tr>
					<td width="141" height="45" align="center" bgcolor="#EBEBEB"
						class="d5">
						�����ʺţ�
					</td>
					<td width="258" align="left" bgcolor="#EBEBEB">
						<input name="userName" type="text" />
					</td>
				</tr>
				<tr>

				</tr>
				<tr>
					<td height="45" align="center" bgcolor="#EBEBEB" class="d5">
						�������룺
					</td>
					<td align="left" bordercolor="#EBEBEB" bgcolor="#EBEBEB">
						<input name="password" type="password" size="21" />
					</td>
				</tr>
				<tr>
					<td height="45" align="center" bgcolor="#EBEBEB" class="d5">��֤��:</td>
					<td align="left" bordercolor="#EBEBEB" bgcolor="#EBEBEB">
						 <input type = "text" id = "cd" value="" readonly="readonly" name="code"/>  
        				<input type = "button" value="��ȡ��֤��" id="code" onclick="createCode()"/>  
					</td>
				</tr>
				<tr align="left">
					<td height="35" colspan="2" align="right" bgcolor="#EAF0FB"
						class="p16">
						<div align="right">
							<span class="d6"><strong>&nbsp;</strong> </span>
						</div>
					</td>
				</tr>
				<tr>
					<td height="60" colspan="2" valign="bottom">
						<div align="center">
							<input name="submit" type="submit" class="d6" value="��  ¼" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="reset" type="reset" class="d6" value="��  ��" />
						</div>
					</td>
				</tr>
				<tr>
				</tr>
			</table>
		</form>
	</BODY>
</HTML>
