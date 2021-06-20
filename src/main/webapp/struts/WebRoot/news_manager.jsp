<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>新闻列表</title>
		<link href="css/all.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		<div class="top">
		<jsp:include page="common.jsp"></jsp:include>
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div class="all">
			<table border="0" cellspacing="0" cellpadding="0" width="100%" style="font-size:14px;">

						<tr><td>
			<form id="select" action="showallNews" method="post" style="margin:0px;">
				<table width="100%" style="font-size: 12px;background-color: #a2b8ec;color:#333333;" align="center">
					<tr>
						<td>&nbsp;&nbsp;
							新闻来源:
							<input type="text" name="newssource" value="<%=session.getAttribute("source") %>" style="font-size:12px; height:20px; width:100px; border:solid 1px inset; background-color: #ffffff;" />
							&nbsp;&nbsp;新闻标题:
								<input type="text" name="newstitle" value="<%=session.getAttribute("title") %>" style="font-size:12px; height:20px; width:200px; border:solid 1px inset; background-color: #ffffff;" />
							
							<input type="hidden" name="condition" value="select2"/>
							<input type="submit" value="搜索"   style="width:50px; height:20px; font-size:12px; border: solid 1px #22479d; background-color: #f0f0f0; color:#000000;" />
						</td>
					</tr>
				</table>
			</form>
			</td>
			</tr>

					<s:iterator value="#request.all" id="news">
						<tr>
							<td>
								<table width="100%"
									style="font-family: arial; font-size: 12px; border-bottom: dashed 1px #bad3e2;">
									<tr height="30" style="font-size:14px;">
										<td colspan="3">&nbsp;&nbsp;
											<a href="showNews?newsid=<s:property value='#news.newsid'/>" target="_blank"><s:property
													value="#news.title" />
											</a>
										</td>
									</tr>
								
									<tr style="font-size:12px; color:#777777;">
										<td width="150">&nbsp;&nbsp;
											来源：
											<s:property value="#news.source" />
										</td>
										<td  width="200">
											发表日期：
											<s:property value="#news.date" />
										</td>		
										<td>
											阅读数：
											<s:property value="#news.readcount" />
										</td>
										
									</tr>

								</table>

							</td>
						</tr>

					</s:iterator>

					<tr height="25">
						<td style="font-size: 12px; background-color: #bad3e2;" align="center">

							第
							<s:property value="curPage" />
							页/共
							<s:property value="totalPage" />
							页

							<s:if test="curPage>1">
								<a href="showallNews.action?page=${1}">首页</a>
							</s:if>
							<s:if test="curPage<=1">
   首页
    </s:if>
							<s:if test="curPage>1">
								<a href="showallNews.action?page=${curPage-1 }">上一页</a>
							</s:if>
							<s:if test="curPage<=1">
   上一页
    </s:if>
							<s:if test="curPage<totalPage">
								<a href="showallNews.action?page=${curPage+1 }">下一页</a>
							</s:if>
							<s:if test="curPage>=totalPage">
    下一页
    </s:if>
							<s:if test="curPage<totalPage">
								<a href="showallNews.action?page=${totalPage }">尾页</a>
							</s:if>

							<s:if test="curPage>=totalPage">
   尾页
    </s:if>
						</td>
					</tr>
				</table>
</div>	
		<div class="bottom">
		
			<jsp:include page="bottom.jsp"></jsp:include>
			
		</div>
		
	</body>
</html>