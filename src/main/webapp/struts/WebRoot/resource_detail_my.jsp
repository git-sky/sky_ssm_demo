<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title></title>
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
	
	<div class="all">
	<div class="left" align="left">


			<s:set name="resource" value="#request.resource"/>
				
				<table  width="100%" cellpadding="0" cellspacing="1"  style="font-size: 14px; border: solid 1px #cccccc;">
				<tr height="30" style="background-image: url(images/w.gif);"><td colspan="2">&nbsp;</td></tr>
				<tr height="30" style="background-image: url(images/bg_menu.jpg);"><td colspan="2">&nbsp;</td></tr>
				
				<tr bgcolor="#ffffff">
					<td  align="center" colspan="2">
						<table width="100%" cellpadding="0" cellspacing="1" height="50px" style="font-size: 24px">
							<tr><td>
							<s:property value="#resource.resourcename" />
							</td></tr>
						</table>
			
				</td>
				</tr>
				<tr height="30" bgcolor="#ffffff">
					<td>
						【资源类型】：
					
					<s:property value="#resource.resourcetype.resourcetypename" />
					</td>
				
					<td>
						【资源大小】:
						<s:property value="#resource.sizes" />K
					</td>
				</tr>
				<tr height="30" bgcolor="#ffffff">
					<td>
						【下载次数】:
					<s:property value="#resource.downcount" />次
					</td>
				
					<td>
						【发布人】：
						<s:property value="#resource.users.username" />
					</td>
				</tr>
				<tr height="30" bgcolor="#ffffff">
					<td colspan=2>
						【发布日期】：
					<s:property value="#resource.date" />
					</td>
				</tr>
			</table>
			<br/>
			<table  width="100%" cellpadding="0" cellspacing="1"  style="font-size: 14px; border: solid 1px #cccccc;">
				<tr height="25" >
					<td valign="top" bgcolor="#d4e8f0">
						资源简介：
					</td>
					
				</tr>
				<tr height="200">
					<td><s:property value="#resource.instruction" /></td>
				</tr>	
				
				<tr><td>
						<a href='download.action?resourceid=<s:property value="#resource.resourceid" />&fn=<s:property value="#resource.filename" />'>下载地址</a>
				</td></tr>
			</table>
			</div>
			<div class="right">
				<table width="100%" height="400" cellpadding="0" cellspacing="0" style="border: 2px; border-style: solid; border-color: #CEE2FA ">
				<tr height="24" style="background-image:url(images/bg_menu.jpg) ;  ">
					<td>&nbsp;</td>
					<td style="vertical-align: middle; line-height:24px;"><font size="2" face="新宋体">最新资讯</font></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
						<td style="vertical-align: top;"><jsp:include page="news_rec.jsp"></jsp:include></td>
			    </tr>
			</table>
			
			</div>
			</div>
			
	</body>
</html>
