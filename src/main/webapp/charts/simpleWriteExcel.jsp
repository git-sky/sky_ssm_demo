<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="demo.excel.SimpleExcelWrite"%>
<%
	String fileName = "学生成绩信息";
	OutputStream os = response.getOutputStream();
	response.setCharacterEncoding("UTF-8");
	fileName = URLDecoder.decode(fileName, "UTF-8");
	//设置响应头
	response.setHeader("Content-disposition", "attachment;filename="+fileName+".xls");
	//定义输出类型
	response.setContentType("application/msexcel");
	new SimpleExcelWrite().createExcel(os);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>excel文档下载</title>
	</head>

	<body>

	</body>
</html>
