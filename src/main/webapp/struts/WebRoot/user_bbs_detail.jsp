<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>主题信息</title>
		<link href="css/newstyle.css" rel="stylesheet" type="text/css" />
		<link href="css/all.css" rel="stylesheet" type="text/css">
		
		
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
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
<s:set name="bbs" value="#request.bbs"/>
					<s:set name="page" value="%{requestScope.page}"/>

		<table width="100%" border="0" align="center" cellpadding="0"	cellspacing="0" bgcolor="#9fb7e7">
				<tr height="30">
					<td align="left">&nbsp;&nbsp;<a href="showmyBbs?userid<%=userid%>">我的主题</a>&gt;&gt;<s:property value="#bbs.title" /></td>
				</tr>
			</table>

		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					
				</td>
			</tr>
		
			<tr>
			
					<td colspan="2" width="100%" height="30"
								class="STYLE6" style="background-image:url(images/h.png)">
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
										
								<td rowspan="2" width="100" height="30" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> <s:property
													value="#reply.users.username" /> </span>
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
									<div>
									<span>${reply.contents}</span>
									
										
									</div>
								</td>
							</tr>
							</table>
							</td>
							</tr>
							<tr height="2"><td colspan="2"></td></tr>
						</s:iterator>
							 <tr>
	 <td colspan="9"  height="25" style="background-image: url(images/h.png)"><div align="center"><span class="STYLE10">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showBbs.action?bbsid=<s:property value="#bbs.bbsid"/>&page=${totalPage }">尾页</a>
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
								<td align="center" class="STYLE10">
									<input type="submit" value="回复" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		</div>
	<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>


