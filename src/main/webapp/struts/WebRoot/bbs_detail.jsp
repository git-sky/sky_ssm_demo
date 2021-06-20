<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
		<link href="css/all.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	
		<div class="top">
		<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" bordercolor="#62a4cf" style="border-collapse: collapse;">
			<tr>
				<td colspan="2">
					<s:set name="bbs" value="#request.bbs"/>
					<s:set name="page" value="%{requestScope.page}"/>
				</td>
			</tr>
			
			<tr>
					<td colspan="2" width="100%" height="30"
								class="STYLE6" style="background-color:#bad3e2; height:30px;">
								<div align="center">
									<span class="STYLE10">标题： <s:property value="#bbs.title" />
									</span>
								</div>

					</td>
			</tr>
			<tr height="2"><td colspan="2"></td></tr>				
			<tr>
				<td colspan="2">
						<table width="100%" cellpadding="0" cellspacing="0" border="1" bordercolor="#62a4cf" style="border-collapse: collapse;">
						<tr>
							<td width="100"  rowspan="2" height="30" bgcolor="#FFFFFF" class="STYLE19">
								<div align="center">
									<span class="STYLE19"><s:property
											value="#bbs.users.username" /> </span>
								</div>
							</td>
							<td height="30" bgcolor="#FFFFFF" class="STYLE19">
								<div>
									<span class="STYLE10">&nbsp;&nbsp;发表于&nbsp;&nbsp;<s:property value="#bbs.date" />
									</span>
								</div>
							</td>
							
						
						</tr>

						<tr>
							<td colspan="2" height="100px" bgcolor="#FFFFFF" class="STYLE19">
								<div style="margin: 5px;">
									<span>${bbs.contents}</span>
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
									<table width="100%" cellpadding="0" cellspacing="0" border="1" bordercolor="#62a4cf" style="border-collapse: collapse;">
							<tr>
										
								<td rowspan="2" width="100" height="30" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<span class="STYLE19"><s:property
													value="#reply.users.username" /></span>
									</div>
								</td>

								<td height="30" bgcolor="#FFFFFF" class="STYLE19">
									<div>&nbsp;&nbsp;
										回复于
										<s:property value="#reply.date" />
									</div>
								</td>
								
								
							</tr>
							<tr>
								<td colspan="3" height="100px" bgcolor="#FFFFFF" class="STYLE19">
									<div style="margin: 5px;">
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
	 <td colspan="9"  height="25" style="background-color:#bad3e2;" align="center"><div><span class="STYLE10">
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
					<br/>
				<!-- 回复 -->
					<form action="addReply" method="post" onsubmit="return check();" style="margin:0px;">
					
					<input type="hidden" name="page" id="page" value="${page}">
					
						<table width="100%">
							<tr>
								<td><input type="hidden" id="flag" name="flag"
										value="2" />
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
	
				</div>
				<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
			</div>
	</body>
</html>



