<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
	<title>后台管理工作平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	   <%if(null==session.getAttribute("admin")){
		   out.print("<script>window.location = '/web/admin/adminLogin.jsp'</script>");
	   }
	   %>
  </head>
		<frameset rows="85,*" frameborder="no" border="0" framespacing="0"> 
			<frame src="admin/top.jsp" name="topFrame"
			 id="topFrame" scrolling="no" noresize="noresize" />
			<frame src="admin/center.html" name="mainFrame" id="mainFrame" scrolling="auto" />
		</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
