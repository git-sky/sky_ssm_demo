<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>主题列表</title>
		<link href="css/newstyle.css" rel="stylesheet" type="text/css" />
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


		<table width="99%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<s:set name="bbs" value="#request.bbs"/>
					<s:set name="page" value="%{requestScope.page}"/>
				</td>
			</tr>
			
			<tr height="30"><td class="STYLE6" ><a href="showallBbs?page=${page}">留言主题</a>&gt;&gt;<s:property value="#bbs.title" /></td></tr>
			<tr>
					<td colspan="2" width="100%" height="30"
								class="STYLE6" bgcolor="#69a8d2">
								<div align="center">
									<span class="STYLE10">标题： <s:property value="#bbs.title" />
									</span>
								</div>

					</td>
			</tr>
			<tr height="2"><td colspan="2"></td></tr>				
			<tr>
				<td colspan="2">
						<table width="100%" cellpadding="0" cellspacing="1px" bgcolor="#62a4cf">
						<tr>
							<td width="10%"  rowspan="2" height="30" bgcolor="#FFFFFF" class="STYLE19">
								<div align="center">
									<span class="STYLE19"><s:property
											value="#bbs.users.username" /> </span>
								</div>
							</td>
							<td height="30" width="80%" bgcolor="#FFFFFF" class="STYLE19">
								<div>
									<span class="STYLE10">&nbsp;&nbsp;发表于<s:property value="#bbs.date" />
									</span>
								</div>
							</td>
							<td width="10%"  height="30" bgcolor="#FFFFFF">
								<div align="center">
									<span class="STYLE10">删除</span>
								</div>
							</td>
						</tr>

						<tr>
							<td colspan="3" height="100px" bgcolor="#FFFFFF" class="STYLE19">
								<div>
									<span>	${bbs.contents} </span>
								</div>
							</td>
						</tr>
						</table>
							</td>
						</tr>
						<tr height="2"><td colspan="2"></td></tr>
							
						<s:iterator value="#request.all" id="reply">
							<tr>
								<td colspan="2">
								   <table width="100%" cellpadding="0" cellspacing="1px" bgcolor="#62a4cf">
							<tr>
										
								<td rowspan="2" width="10%" height="30" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> <s:property
													value="#reply.users.username" /> </span>
									</div>
								</td>

								<td height="30" width="80%" bgcolor="#FFFFFF" class="STYLE19">
									<div>&nbsp;&nbsp;
										回复于
										<s:property value="#reply.date" />
									</div>
								</td>
								
								<td width="10%" height="30" bgcolor="#FFFFFF">
									<div align="center" class="STYLE21">
										<a
											href="deleteReply.action?replyid=<s:property value='#reply.replyid'/>&bbsid=<s:property value='#bbs.bbsid' />&flag=2&page=${page}" 
		onclick="return confirm('你真的要删除吗?');">删除</a>
									
										
									
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3" height="100px" bgcolor="#FFFFFF" class="STYLE19">
									<div>
									${reply.contents}
										
									</div>
								</td>
							</tr>
							</table>
							</td>
							</tr>
							<tr height="2"><td colspan="2"></td></tr>
						</s:iterator>
							 <tr>
	 <td colspan="9"  height="25"><div align="center"><span class="STYLE10">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&flag=2&page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&flag=2&page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&flag=2&page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&flag=2&page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></span></div></td> 
  </tr>
					</table>
					
				<!-- 回复 -->
					<form action="addReply" method="post" onsubmit="return check();">
					
					<input type="hidden" name="page" id="page" value="${page}">
					
						<table width="100%">
							<tr>
								<td><input type="hidden" name="flag" value="2"/>
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
								<td  align="center">
									<input type="submit" value="回复" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>

		</table>
	</body>
</html>


