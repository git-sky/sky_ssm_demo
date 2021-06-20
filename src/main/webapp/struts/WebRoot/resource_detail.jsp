<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>资源信息</title>
		<script language="javascript">
	function check() {
		if (document.getElementById('title').value == "") {
			alert("标题不能为空！");
			return false;
		} else if (document.getElementById('contensts').value == "") {
			alert("内容不能为空！");
			return false;
		}

		return true;
	}
</script>
	<link href="css/all.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
			<s:set name="resource" value="#request.resource"/>
				
				<table align="center" height="100%"  width="100%" cellpadding="0" cellspacing="1"  >
				<tr height="26" style="background-image: url(images/h.png);"><td colspan="2">&nbsp;</td></tr>
				
				<tr><td>
				<table align="center" height="100%"  width="80%" border="1" bordercolor="#9fb7e7" style="font-size: 14px; border-collapse: collapse;"><tr bgcolor="#ffffff">
					<td  align="center" colspan="2">
						<table align="center" width="100%" cellpadding="0" cellspacing="0" height="50px" style="font-size: 24px;text-align:center;background-image: url(images/m.gif);">
							<tr><td>
							<s:property value="#resource.resourcename" />
							</td></tr>
						</table>
					</td></tr>
			
			
				<tr height="30" bgcolor="#ffffff">
					<td>
						【资源类型】：
					
					<s:property value="#resource.resourcetype.resourcetypename" />
					</td>
				
					<td>
						【资源大小】：
						<s:property value="#resource.sizes" />K
					</td>
				</tr>
				<tr height="30" bgcolor="#ffffff">
					<td>
						【下载次数】：
					<s:property value="#resource.downcount" />次
					</td>
				
					<td>
						【发布人】：
						<s:property value="#resource.users.username" />
					</td>
				</tr>
				<tr height="30" bgcolor="#ffffff">
					<td>
						【发布日期】：
					<s:property value="#resource.date" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr height="30" bgcolor="#ffffff">
					<td colspan="2">
						【资源简介】：
					</td>
					
				</tr>
				<tr height="100" valign="top">
					<td colspan="2">&nbsp;&nbsp;<s:property value="#resource.instruction" /></td>
				</tr>	
				
				<tr height="30" align="left">
				<td colspan="2">
				
						<a href='download.action?resourceid=<s:property value="#resource.resourceid" />&fn=<s:property value="#resource.filename" />'><img alt="" src="images/download.gif" height="30" border="0"></a>
				</td>
				</tr></table></td></tr>
			</table>

			</div>
			<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
			</div>
	</body>
</html>
