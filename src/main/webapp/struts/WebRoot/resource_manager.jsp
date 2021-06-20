<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>资源列表</title>
			<link href="css/all.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
			<table width="100%" cellspacing="0" cellpadding="0" border="0" style="margin:0px;">
			<tr><td>
			<form id="select" action="showallResource" method="post" style="margin:0px;">
				<table width="100%" style="font-size: 12px;background-color: #a2b8ec;color:#333333;" align="center">
					<tr>
						<td>&nbsp;&nbsp;
						资源类型:
	
									<s:select name="resourcetypeid" list="alltype"
										listKey="resourcetypeid" listValue="resourcetypename"
										headerKey="0" headerValue="所有"
										value="#session.resourcetype.resourcetypeid"
											theme="simple" cssStyle="width:100px; height:20px;"/>  &nbsp;&nbsp;
						
							资源名称:
								<input type="text" name="resourcetitle" value="<%=session.getAttribute("title") %>" style="font-size:12px; height:20px; width:200px; border:solid 1px inset; background-color: #ffffff;" />
							
										<!-- 把请求的页传过去 -->
							<input type="hidden" name="condition" value="select"/>
							<input type="submit" value="搜索"   style="width:50px; height:20px; font-size:12px; border: solid 1px #22479d; background-color: #f0f0f0; color:#000000;" />
						</td>
					</tr>
				</table>
			</form>
			</td>
			</tr>
				<s:iterator value="#request.all" id="resource">
					<tr>
						<td>
						<table width="100%" align="center" style="font-family:arial; font-size:12px; border-bottom: dashed 1px #bad3e2;" >
						
							<tr height="20">
								<td rowspan="2" width="150">
								<img src="images/upload.gif">
								</td>
								<td style="vertical-align: bottom;">
									
										<font size="3"><a href="showResource?resourceid=<s:property value='#resource.resourceid'/>&flag=2" target="_blank"><s:property
											value="#resource.resourcename" /></a></font>
								
								</td>	
							</tr>
							
							<tr height="100">
								<td><s:property value="#resource.instruction" /></td>
							</tr>
							<tr>
								<td>
								&nbsp;&nbsp;
									下载次数：<s:property value="#resource.downcount" />次
								</td>
							
								<td>
									<font color="#36929c">资源类型：</font><s:property value="#resource.resourcetype.resourcetypename" />
									<font color="#36929c">用户名：</font><s:property value="#resource.users.username" />
									<font color="#36929c">发布日期：</font><s:property value="#resource.date" />
								</td>
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
				<a href="showallResource.action?page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showallResource.action?page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallResource.action?page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallResource.action?page=${totalPage }">尾页</a>
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