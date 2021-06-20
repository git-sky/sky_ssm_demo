<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>忘记密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 <link href="css/all.css" rel="stylesheet" type="text/css"/>
 
 		<script type="text/javascript" language="javascript"> 
			function checkvalid(){
			    var username=document.getElementById('username');
				    if(username.value==""){
				    alert("用户名不能为空！");
				    return false;
					}
					     var question=document.getElementById('question');
					     		    if(question.value==""){
					    alert("密码问题不能为空！");
					    return false;
			}
			  var answer=document.getElementById('answer');
					     		    if(answer.value==""){
					    alert("问题答案不能为空！");
					    return false;
			}
		      		    return true;
			}
		</script>
	</head>
	<body>
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
		<div class="all">
			  <form action="forget" method="post" onsubmit="return checkvalid();">
				  <table width="60%"  align="center" bgcolor="#FFFFCC"  style="border: solid 1px #9fb7e7;vertical-align: center; margin-top: 10px; font-size: 12px;">
				 <tr height="20" align="center"><td colspan="2"><s:actionerror/></td></tr>
				    <tr height="30" align="center">
					    <td width="70%" align="right">&nbsp;&nbsp;用户名:
					   <input type="text" id="username" name="username"/>
					   </td>
					   <td width="30%" align="left">	<s:fielderror fieldName="username"/></td>
					 </tr>
				    <tr height="30" align="center">
					    <td align="right">
					  密码问题:
					   <input type="text" id="question" name="question"/>
					   </td>
					    <td align="left">	<s:fielderror fieldName="question"/></td>
					 </tr>
				 <tr height="30" align="center">
					   <td align="right">
					   密码答案:
					   <input type="text" id="answer" name="answer" />
					   </td>
					    <td align="left">	<s:fielderror fieldName="answer"/></td>
				   </tr>
				 <tr height="30" align="center">
					    <td colspan="2">
					   <input type="submit" value="确定" style="width: 50px; height: 20px; font-size: 12px; border: solid 1px #666;" />
					   </td>
					</tr>
				   </table>

		   </form>
	    </div>
		<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
   </body>
</html>
