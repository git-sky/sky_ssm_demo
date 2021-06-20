<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title></title>
		<link href="css/newstyle.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
<a href="#" onclick="window.history.back()">返回用户列表</a>
		<table>
			<tr>
				<td align="center">
				<table><tr><td>主题</td></tr></table>
					<table width="100%" border="1" bgcolor="" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td>
								主题
							</td>
							<td>
								回复数
							</td>
							<td>
								发表时间
							</td>
							
							<td>
								删除
							</td>
						</tr>
						<s:iterator id="bbs" value="#request.bbs">
							<tr>
								<td>
									<a href="showBbs?bbsid=<s:property value="#bbs.bbsid"/>"><s:property
											value="#bbs.title" /> </a>
								</td>
								<td>
									<s:property value="#bbs.replycount" />

								</td>
								<td>
									<s:property value="#bbs.date" />

								</td>
								<td>
									<a href="deleteBbs?bbsid=<s:property value="#bbs.bbsid" />">删除</a>

								</td>
							</tr>
						</s:iterator>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td>
								资源
							</td>
						</tr>
					</table>
					<table width="100%" border="1" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>
								资源名称
							</td>
							<td>
								资源大小
							</td>
							<td>
								下载次数
							</td>
							<td>
								资源类型
							</td>
							<td>
								上传时间
							</td>
							<td>
								删除
							</td>
						</tr>
						<s:iterator id="resource" value="#request.resource">
							<tr>
								<td>

									<a
										href="showResource?resourceid=<s:property value="#resource.resourceid"/> "><s:property
											value="#resource.resourcename" /> </a>

								</td>
								<td>
									<s:property value="#resource.sizes" />
								</td>
								<td>
									<s:property value="#resource.downcount" />
								</td>
								<td>
									<s:property value="#resource.resourcetype.resourcetypename" />
								</td>
								<td>
									<s:property value="#resource.date" />
								</td>
								<td>
									<a href="deleteResource?resourceid=<s:property value="#resource.resourceid" />">删除</a>

								</td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								考试
							</td>
						</tr>
					</table>
					<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0"
						style="border: solid 1px #cccccc">

						<tr>
							<td>
								考试章节
							</td>
							<td>
								考试得分
							</td>
							<td>
								考试时间
							</td>
						</tr>
						<s:iterator id="score" value="#request.score">
							<tr>
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
					</table>
				</td>
				<td></td>
			</tr>
		</table>
	</body>
</html>

