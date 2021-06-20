<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>主题</title>
		<link href="css/newstyle.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0">
		
		<tr><td>
				<form action="showallBbs" method="post" />
				<table width="100%" style="font-size: 14px; background-color: #69a8d2; text-align:center; margin-top:5px;" align="center">
						<tr>
							<td>主题 ：
								<input type="text" name="bbstitle" value="<%=session.getAttribute("title") %>" style="font-size:12px; height:20px; border:solid 1px inset" />
									<input type="hidden" name="condition" value="select2"/>
								<input type="submit" value="查询"   style="width:50px; height:20px; font-size:12px; border: solid 1px #666;" />
							</td>
						</tr>
					</table>
				</form>
		</td></tr>
		
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#69a8d2">
						<tr>
							<td width="45%" height="25">
								<div align="center">
									<span class="STYLE10">主题</span>
								</div>
							</td>
							<td width="10%" height="25">
								<div align="center">
									<span class="STYLE10">回复</span>
								</div>
							</td>
							<td width="15%" height="25">
								<div align="center">
									<span class="STYLE10">作者</span>
								</div>
							</td>
							<td width="15%" height="25">
								<div align="center">
									<span class="STYLE10">发表日期</span>
								</div>
							</td>
							<td width="15%" height="25">
								<div align="center">
									<span class="STYLE10">基本操作</span>
								</div>
							</td>
						</tr>
						<s:iterator value="#request.all" id="bbs">
							<tr>
								<td height="30" bgcolor="#FFFFFF" class="STYLE6">
									<div align="left">
										<span class="STYLE19">&nbsp;&nbsp; <a
											href="showBbs?bbsid=<s:property value='#bbs.bbsid'/>&flag=2&page=<s:property value="curPage" />"><s:property
													value="#bbs.title" />
										</a>
										</span>
									</div>
								</td>
								<td height="30" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#bbs.replycount" />
									</div>
								</td>
								<td height="30" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#bbs.users.username" />
									</div>
								</td>
								<td height="30" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<s:property value="#bbs.date" />
									</div>
								</td>
								<td height="30" bgcolor="#FFFFFF">
									<div align="center" class="STYLE21">
										<a
											href="deleteBbs.action?bbsid=<s:property value='#bbs.bbsid'/>&page=<s:property value="curPage" />" onclick="return confirm('你真的要删除吗?');">删除</a>
									</div>
								</td>
							</tr>
						</s:iterator>
						
						<tr>

							<td colspan="8" height="25">
								<div align="center">
									<span class="STYLE10"> 第 <s:property value="curPage" />
										页/共 <s:property value="totalPage" /> 页 <s:if test="curPage>1">
											<a href="showallBbs.action?page=${1}">首页</a>
										</s:if> <s:if test="curPage<=1">
   首页
    </s:if> <s:if test="curPage>1">
											<a href="showallBbs.action?page=${curPage-1}">上一页</a>
										</s:if> <s:if test="curPage<=1">
   上一页
    </s:if> <s:if test="curPage<totalPage">
											<a href="showallBbs.action?page=${curPage+1 }">下一页</a>
										</s:if> <s:if test="curPage>=totalPage">
    下一页
    </s:if> <s:if test="curPage<totalPage">
											<a href="showallBbs.action?page=${totalPage }">尾页</a>
										</s:if> <s:if test="curPage>=totalPage">
   尾页
    </s:if>
									</span>
								</div>
							</td>
						</tr>

					</table>

				</td>
			</tr>
		</table>

	</body>
</html>
