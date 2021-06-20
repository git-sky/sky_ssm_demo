<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>资源</title>
	
	</head>

	<body>
		
					<table style="font-size:14px;">	<tr height="30"><td>你的当前位置: <a href="user_detail.jsp?userid=<%=request.getAttribute("userid") %>">用户信息</a>&gt;&gt;用户资源</td></tr></table>
								<table align="center" width="100%" border="1" bordercolor="#69a8d2" align="center" cellpadding="0" cellspacing="0" style="font-size:12px; border-collapse: collapse; text-align: center;">
					
							<tr height="25" bgcolor="#69a8d2">
							<td width="45%">
								资源名称
							</td>
							<td width="10%">
								资源大小
							</td>
							<td width="10%">
								下载次数
							</td>
							<td width="10%">
								资源类型
							</td>
							<td width="15%">
								上传时间
							</td>
							<td width="10%">
								删除
							</td>
						</tr>
						<s:iterator id="resource" value="#request.resource">
							<tr height="30">
								<td align="left">
											&nbsp;&nbsp;
									<a
										href="showResource?resourceid=<s:property value="#resource.resourceid"/>&userid=<s:property value="#resource.users.userid"/>&page=${curPage} "><s:property
											value="#resource.resourcename" /> </a>

								</td>
								<td>
									<s:property value="#resource.sizes" />K
								</td>
								<td>
									<s:property value="#resource.downcount" />
								</td>
								<td>
									<s:property value="#resource.resourcetype.resourcetypename" />
								</td>
								<td>
									<s:property value="#resource.date" />
								</td>
								<td>
									<a href="deleteResource?resourceid=<s:property value="#resource.resourceid" />&flag=2&userid=<s:property value="#resource.users.userid"/>&page=${curPage}" onclick="return confirm('你确认要删除吗？');" >删除</a>

								</td>
							</tr>
						</s:iterator>
					<tr height="25" align="center">
	 <td colspan="9"  height="25">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showuserResource.action?userid=<s:property value="#resource.users.userid"/>&page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showuserResource.action?userid=<s:property value="#resource.users.userid"/>&page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showuserResource.action?userid=<s:property value="#resource.users.userid"/>&page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showuserResource.action?userid=<s:property value="#resource.users.userid"/>&page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></td> 
  </tr>


					</table>
			
	</body>
</html>

