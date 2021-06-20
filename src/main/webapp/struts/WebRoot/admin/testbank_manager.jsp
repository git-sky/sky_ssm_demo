<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>题库列表</title>
<link href="css/newstyle.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	
	
<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
	
		<tr>
	     <td>
	  
			<s:form action="/admin/showallTestbank" method="post" theme="simple">
			<table width="100%" style="font-size: 14px; background-color: #69a8d2; text-align:center; margin-top:5px;" align="center">
					<tr>
						<td>
						章节:
									
											<s:select name="chapterid" list="alltype"
										listKey="chapterid" listValue="name"
										headerKey="0" headerValue="所有"
											value="#session.chapter.chapterid"  theme="simple" />
										
							&nbsp;&nbsp;试题题目:
							
							<input type="text" name="testbanktitle" value="<%=session.getAttribute("title") %>" style="font-size:12px; height:20px; border:solid 1px inset" />
							
									<input type="hidden" name="condition" value="select"/>
							<input type="submit" value="查询"   style="width:50px; height:20px; font-size:12px; border: solid 1px #666;"/>
						</td>
					</tr>
				</table>
		</s:form>
			
			</td>
		</tr>
  <tr>
    <td>
    
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#69a8d2">
	      <tr>
	        <td width="70%" height="25"><div align="center"><span class="STYLE10">试题题目</span></div></td>
	        <td width="15%" height="25"><div align="center"><span class="STYLE10">试题章节</span></div></td>
	        <td width="15%" height="25"><div align="center"><span class="STYLE10">基本操作</span></div></td>
	      </tr>
	    			<s:iterator value="#request.all" id="testbank">
	      <tr>
			<td height="30" bgcolor="#FFFFFF" class="STYLE6"><div align="left"><span class="STYLE19">&nbsp;&nbsp;<s:property value="#testbank.title" /></span></div>
			</td>
			<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#testbank.chapter.name" /></div></td>
			<td height="30" bgcolor="#FFFFFF"><div align="center" class="STYLE21"> 
			<a
								href="updateTestbank.action?testid=<s:property value='#testbank.testid'/>&chapterid=<s:property value='#testbank.chapter.chapterid'/>&page=<s:property value="curPage" />">修改</a> | 
					<a
								href="deleteTestbank.action?testid=<s:property value='#testbank.testid'/>&page=<s:property value="curPage" />"  onclick="return confirm('你真的要删除吗?');">删除</a> 
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
				<a href="showallTestbank.action?page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showallTestbank.action?page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallTestbank.action?page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallTestbank.action?page=${totalPage }">尾页</a>
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


