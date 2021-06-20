<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>列表</title>
	</head>
	<body>
		<center>
			<table cellspacing="1" bgcolor="#9fb7e7" width="100%" style="text-align: center;font-size: 12px;">

				<tr  height="25">
					<th width="33%">
						所考章节
					</th>
					<th width="33%">
						考试分数
					</th>
					<th>
						考试日期
					</th>
					
				</tr>
				<s:iterator value="#request.all" id="score">
					<tr bgcolor="#ffffff" height="30">
						<td>
							<s:property value="#score.chapter.name" />
						</td>
						<td>
							<s:property value="#score.grade" />
						</td>

						<td>
							<s:property value="#score.date" />
						</td>
						
					</tr>
				</s:iterator>
<tr height="25"><td colspan="3">
			第
			<s:property value="curPage" />
			页/共
			<s:property value="totalPage" />
			页

			<s:if test="curPage>1">
				<a href="showallScore.action?page=${1}">首页</a>
			</s:if>
			<s:if test="curPage<=1">
   首页
    </s:if>
			<s:if test="curPage>1">
				<a href="showallScore.action?page=${curPage-1 }">上一页</a>
			</s:if>
			<s:if test="curPage<=1">
   上一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallScore.action?page=${curPage+1 }">下一页</a>
			</s:if>
			<s:if test="curPage>=totalPage">
    下一页
    </s:if>
			<s:if test="curPage<totalPage">
				<a href="showallScore.action?page=${totalPage }">尾页</a>
			</s:if>

			<s:if test="curPage>=totalPage">
   尾页
    </s:if>
</td></tr>
			</table>


		</center>
	</body>
</html>