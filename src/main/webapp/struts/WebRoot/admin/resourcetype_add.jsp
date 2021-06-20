<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>添加资源类型</title>
		<script language="javascript">
      function check(){
                if (document.getElementById('title').value.replace(/\s/g,"") == "") {
                    alert("资源类型不能为空！");
                    return false;
                }
                                
                return true;
            }
    </script>
	</head>

	<body>

		<form method="post" action="addResourcetype?a=1" onsubmit="return check();">
			<br>
				<table align="center" width="60%" border="0" cellspacing="1" cellpadding="0" bgcolor="#69a8d2" style="font-size: 14px;">
				<tr height="25"><td colspan="2" align="center" >资源类型添加</td>
				</tr>
				<tr bgcolor="ffffff">
					<td align="right" width="250" height="30">
						资源类型：
					</td>
					<td>
						<input type="text" id="title" name="title" size="30"  style="border:solid 1px inset; background-color: #dddddd"/>
					</td>
				</tr>
				<tr  bgcolor="ffffff">
					<td colspan="2" height="35" align="center">
						<input type="submit" value="添加"  style="width:60px; height:25px; font-size:12px; border: solid 1px #666;"/>
					</td>
				</tr>	

			</table>
		</form>

	</body>