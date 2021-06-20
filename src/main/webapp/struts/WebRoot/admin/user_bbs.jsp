<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title></title>
	</head>

	<body>
	
	<table style="font-size:14px;">	<tr height="30"><td>你的当前位置: <a href="user_detail.jsp?userid=<%=request.getAttribute("userid") %>">用户信息</a>&gt;&gt;用户主题</td></tr></table>
			
	<table align="center" width="100%" border="1" bordercolor="#69a8d2" align="center" cellpadding="0" cellspacing="0" style="font-size:12px; border-collapse: collapse; text-align: center;">
					
						<tr height="25" bgcolor="#69a8d2">
							<td width="60%">
								主题
							</td>
							<td width="10%">
								回复数
							</td>
							<td width="15%">
								发表时间
							</td>
							
							<td width="15%">
								删除
							</td>
						</tr>
						<s:iterator id="bbs" value="#request.bbs">
							<tr height="30">
								
								<td align="left">&nbsp;&nbsp;
									<a href="showBbs?bbsid=<s:property value="#bbs.bbsid"/>&userid=<s:property value="#bbs.users.userid"/>&page=${curPage}"><s:property
											value="#bbs.title" /> </a>
								</td>
								<td>
									<s:property value="#bbs.replycount" />

								</td>
								<td>
									<s:property value="#bbs.date" />

								</td>
								
								<td>
									<a href="deleteBbs?bbsid=<s:property value="#bbs.bbsid"/>&flag=2&userid=<s:property value="#bbs.users.userid"/>&page=${curPage}" onclick="return confirm('你真的要删除吗?');">删除</a>

								</td>
							</tr>
						</s:iterator>
						<tr height="25" align="center">
	 <td colspan="9">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showuserBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showuserBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showuserBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showuserBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></td> 
  </tr>
  
					</table>
	</body>
</html>

