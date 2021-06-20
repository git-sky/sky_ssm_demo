<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title></title>
   </head>
  
  <body>
  <table>
   <s:iterator id="resource" value="#request.resource">
   <tr><td align="left"><img src="images/li.gif" />&nbsp;&nbsp;<a href="showResource?resourceid=<s:property value='#resource.resourceid'/>&flag=2" target="_blank"><s:property
									value="#resource.resourcename" /> </a></td></tr>
   </s:iterator>
   </table>
  </body>
</html>
