<%@ page language="java" import="java.util.*,entity.*;" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <div align="right" style="font-size: 12px; color: #777777; height: 20px; background-image: url(images/nav_bg.gif);" >
		<%if (null==session.getAttribute("user")) {%>
		<span>你还没有登录&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.jsp">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<%}else{ %>
		<span><a style="color: #e28822;">欢迎<%=((Users)session.getAttribute("user")).getUsername()%></a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="user.jsp">我的空间</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout.jsp">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<%} %>
</div>
  </body>
</html>
