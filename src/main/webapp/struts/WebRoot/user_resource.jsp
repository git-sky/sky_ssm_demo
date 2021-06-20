<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>资源列表</title>


	</head>
	<body>
	
	
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

  <tr>
    <td>
    
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9fb7e7" style="font-size:12px;">
	      <tr height="25">
	        <th width="60%"><div align="center">资源名称</div></th>
	        <th width="15%"><div align="center">资源类型</div></th>
	 	    <th width="10%"><div align="center">下载次数</div></th>
	        <th width="15%"><div align="center">上传日期</div></th>
	      </tr>
	    	<s:iterator value="#request.all" id="resource">
	      <tr bgcolor="#ffffff">
			<td height="30" ><div align="left">&nbsp;&nbsp;<a href="showResource?resourceid=<s:property value='#resource.resourceid'/>"><s:property
									value="#resource.resourcename" /> </a></div>
			</td>
			<td height="30"><div align="center"><s:property value="#resource.resourcetype.resourcetypename" /></div></td>
			<td height="30"><div align="center"><s:property value="#resource.downcount" /></div></td>
			<td height="30"><div align="center"><s:property value="#resource.date" /></div></td>
			
		 </tr>
		 </s:iterator>
		 <tr height="25">
		
		 <td colspan="8" ><div align="center"><span class="STYLE10">
		

			第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页




			<s:if test="curPage>1">
					<a href="showmyResource.action?page=${1}">首页</a>
				
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showmyResource.action?page=${curPage-1}">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
			<a href="showmyResource.action?page=${curPage+1}">下一页</a>
		
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
			<a href="showmyResource.action?page=${totalPage}">尾页</a>
				
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

