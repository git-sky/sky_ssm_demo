<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>文章</title>
   </head>
  
  <body>
  <table>
   <s:iterator id="article" value="#request.article">
   <tr><td align="left"><img src="images/li.gif" />&nbsp;&nbsp;<a href="showArticle?articleid=<s:property value='#article.articleid'/>" target="_blank"><s:property value="#article.title" /></a></td></tr>
   </s:iterator>
   </table>
  </body>
</html>
