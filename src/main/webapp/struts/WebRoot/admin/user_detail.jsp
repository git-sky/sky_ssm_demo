<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>用户详细信息</title>
		
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<style type="text/css">
		a{
		font-size: 16px;
		cursor: pointer;
		text-decoration: none;
		
		}
		</style>
	</head>

	<body>
	<%String userid=request.getParameter("userid"); 
	String username=request.getParameter("username"); 
	String p=request.getParameter("page"); 
	%>
	<table align="center" style="text-decoration: underline;"><tr><td><a href="showallUser?condition=select">返回用户列表</a></td></tr></table>
		<table align="center" width="30%" height="30%" border="1" bordercolor="#69a8d2" style=" margin:20px;  border-collapse: collapse; text-align: center;">
			<tr height="25">
				<td bgcolor="#69a8d2">用户信息</td>
			</tr>
			<tr>
				<td>
					<a href="showuserBbs.action?userid=<%=userid%>">查看主题</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="showuserResource.action?userid=<%=userid%>">查看资源</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="showuserScore.action?userid=<%=userid%>">查看考试</a>
				</td>
			</tr>
		</table>
	</body>
</html>

