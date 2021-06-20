<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="css/all.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" language="javascript"> 
			function checkvalid(){
		    var username=document.getElementById('name');
		    if(username.value==""){
		    alert("用户名不能为空！");
		    return false;
}
		     var password=document.getElementById('password');
		     		    if(password.value==""){
		    alert("密码不能为空！");
		    return false;
}
		    
		      var check=document.getElementById('validationCode');
		      		     		    if(check.value==""){
		    alert("验证码不能为空！");
		    return false;
}
		      		     		    return true;
			}
		</script>
		
<script  language="javascript" type="text/javascript">
	function refresh() {
		var img = document.getElementById("img_validation_code")
		img.src = "servlet/validationCode.a?" + Math.random();
	}
</script>
	</head>
	<body>
		<div class="top">
		<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
	<div align="center">
		<form method="post" action="userLogin" onsubmit="return checkvalid();">
			<table width="500" height="300"  bgcolor="#FFFFCC"  style="border:solid  1px #9fb7e7; font-size: 12px; margin-top: 10px;" align="center">
				<tr align="center" height="10"><td colspan="3"><font color="red">你还没有登录，请先登录！</font></td></tr>
				<tr height="10"><td colspan="3"><s:actionerror/></td></tr>
				<tr height="30">
					<td align="right" width="150px">
						用户名:
					</td>
					<td width="150px">
						<input type="text" id="name" name="name" style="width:150px;"/>
					</td>
						<td>
					<s:fielderror fieldName="name"/>
					
					</td>
				</tr>
				<tr height="30">
					<td align="right">
						密&nbsp;&nbsp;码:
					</td>
					<td width="150px">
						<input type="password" id="password" name="password" style="width:150px;"/>
					</td>
					<td>
					<s:fielderror fieldName="password"/>
					</td>
				</tr>
				<tr height="30">
					<td align="right">
						验证码:
					</td>
					<td>
						<input type="text" id="validationCode" name="validationCode" style="width:150px;"/>
					
					</td>
						<td>
					<s:fielderror fieldName="validationCode"/>
					</td>
					
				</tr>
				<tr height="30">
				<td>&nbsp;</td>
				<td width="150px">
				<a href="javascript:refresh()" ><img  border="1"  height="20px" width="150px" id="img_validation_code"
			src="servlet/validationCode.a" /></a>
				</td>
				<td align="left"><a href="javascript:refresh()" >看不清?</a></td>
				</tr>
				<tr height="30">
					<td colspan="3" align="center">
						<input type="submit"
								style="width: 50px; height: 25px; font-size: 12px; border: solid 1px #666;"  value="&nbsp;确定&nbsp;" />&nbsp;&nbsp;&nbsp;&nbsp; <input
								type="reset" style="width: 50px; height: 25px; font-size: 12px; border: solid 1px #666;" 
								value="&nbsp;重置&nbsp;" />
					</td>
				</tr>
			</table>
		</form>
			
		</div>
		</div>
	<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>