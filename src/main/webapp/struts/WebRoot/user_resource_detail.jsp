<%@ page language="java" import="java.util.*,entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>资源信息</title>
		<script language="javascript">
	function check() {
		if (document.getElementById('title').value.replace(/\s/g,"") == "") {
			alert("标题不能为空！");
			return false;
		} else if (document.getElementById('contensts').value.replace(/\s/g,"") == "") {
			alert("内容不能为空！");
			return false;
		}

		return true;
	}
</script>
	</head>

	<body>

			<s:set name="resource" value="#request.resource">
			</s:set>
			<%Users u=(Users)session.getAttribute("user");
			int userid=u.getUserid();
		
			%>
		<center>
			<table width="100%" style="border:solid 1px #9fb7e7; border-bottom: 0px; background-color:#9fb7e7; font-size: 14px;">
				<tr height="25">
					<td align="left"><a href="showmyResource?userid<%=userid%>">我的资源列表</a>&gt;&gt;<s:property value="#resource.resourcename" /></td>
				</tr>
			</table>
			
			<table align="center"  width="100%" cellpadding="0" cellspacing="1" bgcolor="#9fb7e7" style="text-align: center;font-size:12px;">
				<tr  height="25" style="background-image: url(images/m.gif);">
					<td width="50%">
						资源名称:
					</td>
					<td>
						<s:property value="#resource.resourcename" />
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" height="25">
					<td>
						资源类型:
					</td>
					<td>
						<s:property value="#resource.resourcetype.resourcetypename" />
					</td>
				</tr>
					<tr bgcolor="#FFFFFF" height="25">
					<td>
						资源大小:
					</td>
					<td>
						<s:property value="#resource.sizes" />K
					</td>
				</tr>
					<tr bgcolor="#FFFFFF" height="25">
					<td>
						下载次数:
					</td>
					<td>
						<s:property value="#resource.downcount" />次
					</td>
				</tr>
					<tr bgcolor="#FFFFFF" height="25">
					<td>
						发布人:
					</td>
					<td>
						<s:property value="#resource.users.username" />
					</td>
				</tr>
					<tr bgcolor="#FFFFFF" height="25">
					<td>
						发布日期:
					</td>
					<td>
						<s:property value="#resource.date" />
					</td>
				</tr>
					<tr bgcolor="#FFFFFF" height="25">
					<td>
						资源简介:
					</td>
					<td>
						<s:property value="#resource.instruction" />
					</td>
				</tr>
					<tr bgcolor="#FFFFFF" height="25">
				<td colspan="2">
						<a href="download.action?resourceid=<s:property value="#resource.resourceid" />&fn=<s:property value="#resource.filename" />">下载地址</a>
				</td>
				</tr>
			</table>

		</center>
	</body>
</html>
