<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>主题</title>
	
		<link href="css/all.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
				<form action="showallBbs" method="post" style="margin:0px;"/>
					<table width="100%" style="font-size: 12px;background-color: #a2b8ec;color:#333333;" align="center">
						<tr>
							<td>&nbsp;&nbsp;主题搜索:
								<input type="text" name="bbstitle" value="<%=session.getAttribute("title") %>" style="font-size:12px; height:20px; width:200px; border:solid 1px inset;" />
									<input type="hidden" name="condition" value="select2"/>
								<input type="submit" value="搜索"   style="width:50px; height:20px; font-size:12px; border: solid 1px #22479d; background-color: #f0f0f0; color:#000000;" />
							</td>
						</tr>
					</table>
				</form>
	
	<table width="100%"><tr align="left"><td><a href="bbs_add.jsp"><img src="images/new_topic.gif" style="border: 0px;"/></a></td></tr></table>
		<table width="100%" border="0" align="center" cellpadding="0"	cellspacing="0" style="border: solid 1px #9fb7e7">
		
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#bad3e2"  >
						<tr style="background-color:#bad3e2; height:25px; font-size:12px;">
							<td width="55%" height="25">
								<div align="center">
									<span class="STYLE10">主题</span>
								</div>
							</td>
							<td width="12%" height="25">
								<div align="center">
									<span class="STYLE10">回复</span>
								</div>
							</td>
							<td width="13%" height="25">
								<div align="center">
									<span class="STYLE10">作者</span>
								</div>
							</td>
							<td width="20%" height="25">
								<div align="center">
									<span class="STYLE10">发表日期</span>
								</div>
							</td>
							
						</tr>
						<s:iterator value="#request.all" id="bbs">
							<tr height="40" bgcolor="#FFFFFF" style="font-size:12px">
								<td  class="STYLE6">
									<div align="left">
										<span class="STYLE19">&nbsp;&nbsp;<img src="images/topicnew.gif"/>&nbsp;&nbsp;&nbsp;<a
											href="showBbs?bbsid=<s:property value='#bbs.bbsid'/>&flag=2&page=<s:property value="curPage" />"><s:property
													value="#bbs.title" />
										</a>
										</span>
									</div>
								</td>
								<td  class="STYLE19">
									<div align="center">
										<s:property value="#bbs.replycount" />
									</div>
								</td>
								<td class="STYLE19">
									<div align="center">
										<s:property value="#bbs.users.username" />
									</div>
								</td>
								<td class="STYLE19">
									<div align="center">
										<s:property value="#bbs.date" />
									</div>
								</td>
								
							</tr>
						</s:iterator>
					<tr align="center">

							<td height="25" style="font-size:12px" colspan="4">
							
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
					
							</td>
						</tr>
						</table>
					

				</td>
			</tr>
		</table>
		</div>
		<br/>
			<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
			</div>
	</body>
</html>
