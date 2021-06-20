<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>资源列表</title>
<link href="css/newstyle.css" rel="stylesheet" type="text/css"/>

	</head>
	<body>
	
	
<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">

	
		<tr>
	     <td>
		
					<form id="select" action="showallResource" method="post">
				<table width="100%" style="font-size: 14px; background-color: #69a8d2; text-align:center; margin-top:5px;" align="center">
					<tr>
						<td>
						资源类型:
	
									<s:select name="resourcetypeid" list="alltype"
										listKey="resourcetypeid" listValue="resourcetypename"
										headerKey="0" headerValue="所有"
										value="#session.resourcetype.resourcetypeid"
											theme="simple" />
							&nbsp;&nbsp;资源名称:
								<input type="text" name="resourcetitle" value="<%=session.getAttribute("title") %>" style="font-size:12px; height:20px; border:solid 1px inset" />
							
										<!-- 把请求的页传过去 -->
							<input type="hidden" name="condition" value="select"/>
							<input type="submit" value="查询"   style="width:50px; height:20px; font-size:12px; border: solid 1px #666;"/>
						</td>
					</tr>
				</table>
			</form>
			
			</td>
		</tr>
  <tr>
    <td>
    
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#69a8d2">
	      <tr>
	        <td width="45%" height="25" ><div align="center"><span class="STYLE10">资源名称</span></div></td>
	        <td width="15%" height="25"><div align="center"><span class="STYLE10">资源类型</span></div></td>
	 	    <td width="10%" height="25"><div align="center"><span class="STYLE10">下载次数</span></div></td>
	        <td width="15%" height="25"><div align="center"><span class="STYLE10">上传日期</span></div></td>
	        <td width="15%" height="25"><div align="center"><span class="STYLE10">基本操作</span></div></td>
	      </tr>
	    	<s:iterator value="#request.all" id="resource">
	      <tr>
			<td height="30" bgcolor="#FFFFFF" class="STYLE6"><div align="left"><span class="STYLE19">&nbsp;&nbsp;<a href="showResource?resourceid=<s:property value='#resource.resourceid'/>&flag=2"><s:property
									value="#resource.resourcename" /> </a></span></div>
			</td>
			<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#resource.resourcetype.resourcetypename" /></div></td>
			<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#resource.downcount" /></div></td>
			<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#resource.date" /></div></td>
			<td height="30" bgcolor="#FFFFFF"><div align="center" class="STYLE21"> 
			<a href="updateResource?resourceid=<s:property value='#resource.resourceid'/>&resourcetypeid=<s:property value='#resource.resourcetype.resourcetypeid'/>&page=<s:property value="curPage" />">修改</a>  |
				<a
								href="deleteResource.action?resourceid=<s:property value='#resource.resourceid'/>&filename=<s:property value='#resource.filename'/>&page=<s:property value="curPage" />"  onclick="return confirm('你真的要删除吗?');">删除</a>
				</div>
			</td>
		 </tr>
		 </s:iterator>
		 <tr>
		
		 <td colspan="8"  height="25"><div align="center"><span class="STYLE10">
		

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
				<a href="showallResource.action?page=${curPage-1}">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
			<a href="showallResource.action?page=${curPage+1}">下一页</a>
		
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
			<a href="showallResource.action?page=${totalPage}">尾页</a>
				
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></span></div>
	    </td> 
	  </tr>
		 
</table>

</td>
</tr>
</table>
			
</body>
</html>

