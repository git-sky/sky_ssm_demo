<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>主题列表</title>
	 <script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>
		
		<script language="javascript">
			window.onload = function() {
					CKEDITOR.replace('contents');
					};
		
      		function check(){
              if (CKEDITOR.instances.contents.getData()=="") {
                    alert("内容不能为空！");
                    return false;
                }
           return true;
            }
          </script>
	</head>
	<body>
<%String userid=request.getParameter("userid");
if(null!=request.getAttribute("userid")){
	userid=request.getAttribute("userid").toString();
}
%>

		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0" style="font-size: 14px;">
			<tr>
				<td>
					<s:set name="bbs" value="#request.bbs"/>
					<s:set name="page" value="%{requestScope.page}"/>
				</td>
			</tr>
			<tr height="30">
				<td colspan="2" style="font-size:14px;">你的当前位置:<a href="user_detail.jsp?userid=<%=userid%>">用户信息</a>&gt;&gt;<a href="showuserBbs.action?userid=<%=userid%>&page=${page}">用户主题</a>&gt;&gt;<s:property value="#bbs.title" /></td>
			</tr>
			<tr align="center">
			
					<td colspan="2" width="100%" height="30"
								 bgcolor="#69a8d2">
								
									标题： <s:property value="#bbs.title" />
								</td>
			</tr>
			<tr height="2"><td colspan="2"></td></tr>				
			<tr>
				<td colspan="2">
						<table width="100%" cellpadding="0" cellspacing="1px" bgcolor="#69a8d2" style="font-size:12px; text-align:center;">
						<tr>
							<td width="10%"  rowspan="2" height="30" bgcolor="#FFFFFF" >
								<s:property	value="#bbs.users.username" /> 
							</td>
							<td width="80%" height="30" bgcolor="#FFFFFF" align="left">
								&nbsp;&nbsp;发表于<s:property value="#bbs.date" />
									
							</td>
							
							<td width="10%" height="30" bgcolor="#FFFFFF">
								删除 
							</td>
						</tr>

						<tr>
							<td colspan="3" height="100px" bgcolor="#FFFFFF" align="left">
									&nbsp;&nbsp;${bbs.contents} 
							</td>
						</tr>
						</table>
							</td>
						</tr>
						<tr height="2"><td colspan="2"></td></tr>
						
						<s:iterator value="#request.all" id="reply">
							<tr>
								<td colspan="2">
								   <table width="100%" cellpadding="0" cellspacing="1px" bgcolor="#62a4cf" style="font-size:12px; text-align:center;"> 
							<tr>
										
								<td rowspan="2" width="10%" height="30" bgcolor="#FFFFFF">
									<s:property
													value="#reply.users.username" />
									
								</td>

								<td width="80%" height="30" bgcolor="#FFFFFF" align="left">
									&nbsp;&nbsp;
										回复于
										<s:property value="#reply.date" />
									
								</td>
								<td width="10%" height="30" bgcolor="#FFFFFF">
									
										<a
											href="deleteReply.action?replyid=<s:property value='#reply.replyid'/>&bbsid=<s:property value='#bbs.bbsid' />&userid=<s:property value="#bbs.users.userid" />&page=${page}" 
		onclick="return confirm('你真的要删除吗?');">删除</a>
									
								</td>
							</tr>
							<tr>
								<td colspan="3" height="100px" bgcolor="#FFFFFF"  align="left">
									
									${reply.contents}
									
									
								</td>
							</tr>
							</table>
							</td>
							</tr>
							<tr height="2"><td colspan="2"></td></tr>
						</s:iterator>
						
						
						 <tr>
	 <td colspan="9"  height="25" bgcolor="#69a8d2"><div align="center"><span class="STYLE10">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&userid=<s:property value="#bbs.users.userid" />&page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&userid=<s:property value="#bbs.users.userid" />&page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&userid=<s:property value="#bbs.users.userid" />&page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&userid=<s:property value="#bbs.users.userid" />&page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></span></div></td> 
  </tr>
					</table>
					
				<!-- 回复 -->
					<form action="addReply" method="post" onsubmit="return check();">
					
					<input type="hidden" name="page" id="page" value="${page}">
					
						<table width="90%" align="center">
							<tr>
								
								<td><input type="hidden" id="userid" name="userid"
										value="<s:property value="#bbs.users.userid" />" />
									<input type="hidden" id="bbsid" name="bbsid"
										value='<s:property value="#bbs.bbsid" />' />
								</td>
							</tr>
							<tr>
								
								<td>
							<textarea name="contents"></textarea>
									
								</td>
							</tr>

							<tr>
								<td align="center">
									<input type="submit" value="回复" />
								</td>
							</tr>
						</table>
					</form>

	</body>
</html>


