<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title></title>
		<link href="css/all.css" rel="stylesheet" type="text/css">
		
	</head>

	<body>
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
	<center>
	<table  width="100%"  bgcolor="#9fb7e7" style="font-size: 14px;"><tr height="20px;"><td>我发表的主题</td><td></td><td></td></tr></table>
				<table  width="100%"  align="center" cellpadding="0" cellspacing="1" bgcolor="#9fb7e7" style="font-size: 12px;">
					
						<tr align="center" style="background-image: url(images/h.png);" height="25">
							<th width="70%">
								主题
							</th>
							<th width="15%">
								回复数
							</th>
							<th width="15%">
								发表时间
							</th>
											
						</tr>
						<s:iterator id="bbs" value="#request.bbs">
							<tr align="center"  bgcolor="#ffffff"  height="30">
								
								<td align="left">&nbsp;&nbsp;<img src="images/topicnew.gif"/>&nbsp;&nbsp;&nbsp;
									<a href="showBbs?bbsid=<s:property value="#bbs.bbsid"/>&userid=<s:property value="#bbs.users.userid"/>&page=${curPage}"><s:property
											value="#bbs.title" /> </a>
								</td>
								<td>
									<s:property value="#bbs.replycount" />

								</td>
								<td>
									<s:property value="#bbs.date" />

								</td>
								
							</tr>
						</s:iterator>
							<tr align="center"  style="background-image: url(images/h.png);" height="25">
	 <td colspan="9"><div align="center"><span class="STYLE10">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showmyBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showmyBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showmyBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showmyBbs.action?userid=<s:property value="#bbs.users.userid"/>&page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></span></div></td> 
  </tr>
  
		</table>
					</center>
	</div>
		<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>

