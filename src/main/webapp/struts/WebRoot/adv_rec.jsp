<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<table style="font-size: 12px">
		   <s:iterator id="adv" value="#request.all">
		   <tr><td align="center"><div align="left"><img alt="" src="images/nav.gif" /><a href="showAdv?advid=<s:property value='#adv.advid'/>" style="text-decoration: none" target="_blank"><s:property value="#adv.title" /></a></div></td></tr>
		   </s:iterator>
  	</table>
  </body>
</html>
