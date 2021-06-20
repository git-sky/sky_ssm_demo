<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>文章列表</title>
			<link href="css/all.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>

	<div class="top">
		<jsp:include page="common.jsp"></jsp:include>
		<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">

			<table border="0" cellspacing="0" cellpadding="0" width="100%" style="font-size:14px;" >
		
		<tr><td>
			<form id="select" action="showallArticle" method="post" style="margin:0px;">
				<table width="100%" style="font-size: 12px;background-color: #a2b8ec;color:#333333;" align="center">
					<tr>
						<td>&nbsp;&nbsp;
						文章类型:
	
									<s:select name="articletypeid" list="alltype"
										listKey="articletypeid" listValue="name"
										headerKey="0" headerValue="所有"
										value="#session.articletype.articletypeid"
											theme="simple" cssStyle="width:100px; height:20px;"/>  &nbsp;&nbsp;
						
							文章名称:
								<input type="text" name="articletitle" value="<%=session.getAttribute("title") %>" style="font-size:12px; height:20px; width:200px; border:solid 1px inset; background-color: #ffffff;" />
							
										<!-- 把请求的页传过去 -->
							<input type="hidden" name="condition" value="select"/>
							<input type="submit" value="搜索"   style="width:50px; height:20px; font-size:12px; border: solid 1px #22479d; background-color: #f0f0f0; color:#000000;" />
						</td>
					</tr>
				</table>
			</form>
			</td>
			</tr>
				<s:iterator value="#request.all" id="article">
				<tr>
					<td>
				<table width="100%"  style="border-bottom: dashed 1px #bad3e2; font-size: 14px;" >
					<tr height="30">
						<td>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="showArticle?articleid=<s:property value='#article.articleid'/>" target="_blank"><s:property value="#article.title" /></a>
						</td>
						<td align="center" width="20%" style="font-size:12px; color: #777777;" ><s:property value="#article.date"/></td>
					</tr>
					
				</table>
				</td>
				</tr>
				</s:iterator>

			<tr height="25">
			    <td style="font-size:12px; background-color: #bad3e2;" align="center">

			第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showallArticle.action?page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showallArticle.action?page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallArticle.action?page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallArticle.action?page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if>
  	</td></tr>
    </table>
    
</div>
		<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>