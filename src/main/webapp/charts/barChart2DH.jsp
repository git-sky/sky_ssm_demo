<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="demo.chart.BarChart2DH"%>
<%
	String fileName=BarChart2DH.getBarChartURL(session,new PrintWriter(out));
	String imgPath=request.getContextPath()+"/servlet/DisplayChart?filename="+fileName;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>柱状2D图表</title>
  </head>
  
  <body>
   	<img src="<%=imgPath %>" border="0">
  </body>
</html>
