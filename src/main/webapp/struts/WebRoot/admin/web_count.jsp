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
				<table width="60%" border="0" cellspacing="1" cellpadding="0" bgcolor="#69a8d2">
					<tr height="25"><td colspan="2" align="center"  bgcolor="#69a8d2" class="STYLE15">网站统计</td></tr>
					<tr height="30"  bgcolor="ffffff">
						<td width="50%">
							<div align="center">
								<span class="STYLE10">注册会员</span>
							</div>
						</td>
						<td>
							<div align="center">
								<span class="STYLE10"><s:property value="#cw.usersCount" />&nbsp;&nbsp;人
								</span>
							</div>
						</td>
					</tr>
					<tr height="30"  bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">主题数</span>
							</div>
						</td>
						<td>
							<div align="center">
								<span class="STYLE10"><s:property value="#cw.bbsCount" />&nbsp;&nbsp;个
								</span>
							</div>

						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">新闻数量</span>
							</div>
						</td>
						<td>
							<div align="center">
								<span class="STYLE10"><s:property value="#cw.newsCount" />&nbsp;&nbsp;篇
								</span>
							</div>
						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">资源数量</span>
							</div>
						</td>
						<td>
							<div align="center">
								<span class="STYLE10"><s:property
										value="#cw.resourceCount" />&nbsp;&nbsp;个
								</span>
							</div>
						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">试题数目</span>
							</div>
						</td>
						<td>
							<div align="center">
								<span class="STYLE10"><s:property
										value="#cw.testbankCount" />&nbsp;&nbsp;个
								</span>
							</div>
						</td>
					</tr>
					<tr height="30" bgcolor="ffffff">
						<td>
							<div align="center">
								<span class="STYLE10">文章数量</span>
							</div>
						</td>
						<td>
							<div align="center">
								<span class="STYLE10"><s:property
										value="#cw.articleCount" />&nbsp;&nbsp;篇
								</span>
							</div>
						</td>
					</tr>
				</table>
		</center>
	</body>
</html>
