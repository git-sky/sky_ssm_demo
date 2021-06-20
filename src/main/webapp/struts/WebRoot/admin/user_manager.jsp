<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>后台管理</title>
<link href="css/newstyle.css" rel="stylesheet" type="text/css"/>
</head>

<body>



<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">

  <tr>
    <td>
    
			<form action="showallUser" method="post">
				<table width="100%" style="font-size: 14px; background-color: #69a8d2; text-align:center; margin-top:5px;" align="center">
					<tr>
						<td>用户名:
							<input type="text" name="name" style="font-size:12px; height:20px; border:solid 1px inset;" value="${requestScope.name}"/>
							<input type="submit" value="查询"   style="width:50px; height:20px; font-size:12px; border: solid 1px #666;" />
						</td>
					</tr>
				</table>
			
			</form>
</td>
</tr>
  <tr>
    <td>
    
    <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#69a8d2">
      <tr>
        <td width="15%" height="25"><div align="center"><span class="STYLE10">用户名</span></div></td>
        <td width="10%" height="25"><div align="center"><span class="STYLE10">用户密码</span></div></td>
        <td width="5%" height="25"><div align="center"><span class="STYLE10">性别</span></div></td>
        <td width="10%" height="25"><div align="center"><span class="STYLE10">密码问题</span></div></td>
        <td width="10%" height="25"><div align="center"><span class="STYLE10">问题答案</span></div></td>
        <td width="10%" height="25"><div align="center"><span class="STYLE10">电子邮件</span></div></td>
        <td width="10%" height="25"><div align="center"><span class="STYLE10">QQ号</span></div></td>
        <td width="15%" height="25""><div align="center"><span class="STYLE10">注册时间</span></div></td>
        <td width="15%" height="25"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
          <s:iterator value="#request.all" id="user">
      <tr>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#user.username" /></div></td>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#user.pass" /></div></td>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#user.sex" /></div></td>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#user.question" /></div></td>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#user.answer" /></div></td>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center">	<s:property value="#user.email" /></div></td>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#user.qq" /></div></td>
		<td height="30" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><s:property value="#user.date" /></div></td>

			<td height="30" bgcolor="#FFFFFF"><div align="center" class="STYLE21"><a href="updateUser.action?userid=<s:property value='#user.userid'/>&page=<s:property value="curPage" />" >修改</a> | <a href="deleteUser.action?userid=<s:property value='#user.userid'/>&page=<s:property value="curPage" />"  onclick="return confirm('你真的要删除该用户的信息吗?');">删除</a> | <a href="user_detail.jsp?userid=<s:property value='#user.userid'/>&username=<s:property value='#user.username'/>&page=${curPage}">查看</a></div></td>
	 </tr>
	     </s:iterator>
	     
	 <tr>
	 <td colspan="9"  height="25"><div align="center"><span class="STYLE10">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showallUser.action?page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showallUser.action?page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallUser.action?page=${curPage+1 }&${requestScope.name}">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallUser.action?page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></span></div></td> 
  </tr>
	 
</table>

</td>
</tr>
</table>
</body>
</html>

