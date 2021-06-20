<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>网站统计</title>
		<link href="css/newstyle.css" rel="stylesheet" type="text/css" />

	</head>

	<body>
		<center>

				<s:set name="cw" value="#request.cw"></s:set>
				<table><tr><td height="10"></td></tr></table>
				<table width="80%" border="0" cellspacing="0" cellpadding="0" style="font-size:12px;">
					
					<tr height="30"  bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">主题数目:</span>
							</div>
						</td>
						<td>
							<div align="left">
								<span class="STYLE10"><s:property value="#cw.bbsCount" />个
								</span>
							</div>

						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">新闻数量:</span>
							</div>
						</td>
						<td>
							<div align="left">
								<span class="STYLE10"><s:property value="#cw.newsCount" />篇
								</span>
							</div>
						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">资源数量:</span>
							</div>
						</td>
						<td>
							<div align="left">
								<span class="STYLE10"><s:property
										value="#cw.resourceCount" />个
								</span>
							</div>
						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">试题数目:</span>
							</div>
						</td>
						<td>
							<div align="left">
								<span class="STYLE10"><s:property
										value="#cw.testbankCount" />道
								</span>
							</div>
						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">文章数量:</span>
							</div>
						</td>
						<td>
							<div align="left">
								<span class="STYLE10"><s:property
										value="#cw.articleCount" />篇
								</span>
							</div>
						</td>
					</tr>
				</table>
		</center>
	</body>
</html>
