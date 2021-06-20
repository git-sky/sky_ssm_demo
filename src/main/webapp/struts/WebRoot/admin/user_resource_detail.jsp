<%@page contentType="text/html;charset=UTF-8"%>
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
<%String userid=request.getParameter("userid");
if(null!=request.getAttribute("userid")){
	userid=request.getAttribute("userid").toString();
}
%>

			<s:set name="resource" value="#request.resource">
			</s:set>
			<table><tr height="30">
				<td colspan="2" style="14px">你的当前位置:<a href="user_detail.jsp?userid=<%=userid%>">用户信息</a>&gt;&gt;<a href="showuserResource.action?userid=<%=userid%>&page=${page}">用户资源</a>&gt;&gt;<s:property value="#resource.resourcename" /></td>
			</tr>
			</table>
		<center>
				<table align="center" bgcolor="#69a8d2"  width="60%"  cellpadding="0" cellspacing="1" style=" font-size:14px; text-align: center;">
			
					<tr height="25" ><td></td><td></td></tr>
					
				<tr bgcolor="#FFFFFF" height="25">
					<td>
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
						<s:property value="#resource.downcount" />
					</td>
				</tr>
					<tr bgcolor="#FFFFFF" height="25">
					<td>
						&nbsp;&nbsp;发布人:
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
