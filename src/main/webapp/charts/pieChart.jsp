<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="demo.pie.PieChart"%>
<%@page import="java.io.PrintWriter"%>
<%
String fileName=PieChart.getPieImgURL(session,new PrintWriter(out));
String imgURL=request.getContextPath()+"/servlet/DisplayChart?filename="+fileName;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>饼状图</title>
  </head>
  
  <body>
    <img border="0" src="<%=imgURL %>">
  </body>
</html>
