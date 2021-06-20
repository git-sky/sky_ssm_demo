<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>成绩</title>
		
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		
	</head>

	<body>

		
					<table style="font-size:14px;">	<tr height="30" class="STYLE14"><td>你的当前位置: <a href="user_detail.jsp?userid=<%=request.getAttribute("userid") %>">用户信息</a>&gt;&gt;用户考试成绩</td></tr></table>
					<table align="center" width="99%" border="1" bordercolor="#69a8d2" align="center" cellpadding="0" cellspacing="0" style="font-size:12px; border-collapse: collapse; text-align: center;">
					
						<tr height="25" bgcolor="#69a8d2">
							<td width="25%">
								考试章节
							</td>
							<td width="25%">
								考试得分
							</td>
							<td width="25%">
								考试时间
							</td>
							<td width="25%">
								删除
							</td>
						</tr>
						<s:iterator id="score" value="#request.score">
							<tr height="30">
								<td>
									<s:property value="#score.chapter.name" />
								</td>
								<td>
									<s:property value="#score.grade" />
								</td>
								<td>
									<s:property value="#score.date" />
								</td>
								<td>
									<a href="deleteScore?scoreid=<s:property value="#score.scoreid" />&flag=2&userid=<s:property value="#score.users.userid"/>&page=${curPage}" onclick="return confirm('你确认要删除吗？');">删除</a>

								</td>
							</tr>
						</s:iterator>
								<tr height="25" align="center">
	 <td colspan="9">
	 第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showuserScore.action?userid=<s:property value="#score.users.userid"/>&page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showuserScore.action?userid=<s:property value="#score.users.userid"/>&page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showuserScore.action?userid=<s:property value="#score.users.userid"/>&page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showuserScore.action?userid=<s:property value="#score.users.userid"/>&page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if></td> 
  </tr>
</table>
				
	</body>
</html>

