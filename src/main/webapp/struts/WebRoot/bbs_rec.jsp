<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>主题</title>
   </head>
  
  <body>
  <table>
   <s:iterator id="bbs" value="#request.bbs">
   <tr><td align="left"><img src="images/li.gif" />&nbsp;&nbsp;<a href="showBbs?bbsid=<s:property value='#bbs.bbsid'/>&flag=2" target="_blank"><s:property
									value="#bbs.title" /> </a></td></tr>
   </s:iterator>
   </table>
  </body>
</html>
