<%@ page language="java" import="java.util.*,entity.Users" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%if (null==session.getAttribute("user")){response.sendRedirect("index.html");} %>
<html>
  <head>
	<title>我的主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
<link href="css/all.css" rel="stylesheet" type="text/css"/>
	</head>
	
	<body>
	
	<div class="top">
		<jsp:include page="top.jsp"></jsp:include>
	</div>
	
		<div class="all">
			<div class="mytop"><table width="100%" style="font-size: 12px;"><tr><td width="30%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;当前登录用户：<font color="green"><%=((Users)session.getAttribute("user")).getUsername()%></font></td></tr></table></div>
			<div class="userleft">
			<jsp:include page="left.jsp"></jsp:include>
			</div>
			<div class="userright">
			 <iframe frameborder="0" height="100%" style="background-color: red;" width="100%"  src="right.jsp" name="myframe"  ></iframe>
			 </div>
		</div>
		
		<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>

</body>

</html>
