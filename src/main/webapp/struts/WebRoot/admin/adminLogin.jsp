<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">

		<title>后台登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

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

		<script language="javascript" type="text/javascript">
		function refresh() {
			var img = document.getElementById("img_validation_code")
			img.src = "servlet/validationCode.a?" + Math.random();
		}
	</script>
	</head>
<body>

<div style="position:absolute;left:50%; margin-left:-500px; margin-top:-15px; width: 1000px; height:500px;  background-image: url(images/login3.jpg); background-repeat:no-repeat;">
<table align="center" width="100%" height="100%" cellSpacing=0 cellPadding=0 border="0">
  <tr>
  	<td width="400">&nbsp;</td>
    <td>
      <table width="100%" height="100%" cellspacing=0 cellpadding=0  border=0>
      <tr height="180"><td>&nbsp;</td></tr>
        <tr>
   		   <td>
           	<form id="form1" method="post" action="adminLogin" onSubmit="return checkvalid();" style="margin:0px;">

				<table height=""  border="0" align="left" bgcolor="">
					<tr height="60">
						<td colspan="3"><font color="red"><s:actionerror/></font></td>
					</tr>
					<tr height="40">
						<td width="150" align="right">
						</td>
						<td  align="left">
							<input type="text" id="name" name="name" style="width: 120px; border: solid 1px inset; color: #555555;"  />
						</td>
						<td style="font-size: 14px">
							<font color="red"><s:fielderror fieldName="name"/></font>
						</td>
					</tr>
					<tr height="40">
						<td align="right">
						</td>
						<td  align="left">
							<input type="password" id="password" name="password" style="width: 120px; border: solid 1px inset; color: #555555;" />
						</td>
						<td style="font-size: 14px">
								<font color="red"><s:fielderror fieldName="password"/></font>
						</td>
					</tr>
					<tr height="40">
						<td align="right">
						</td>
						<td  align="left">
							<input type="text" id="validationCode" name="validationCode"
								style="width: 120px; border: solid 1px inset; color: #555555;" />
						</td>
						<td style="font-size: 12px">
								<font color="red"><s:fielderror fieldName="validationCode" theme="simple"/></font>
						</td>
					</tr>
					<tr height="40">
						<td width="150px" align="right"></td>
						<td align="left" colspan=2 style="font-size:14px;text-decoration: none;">
							<a href="javascript:refresh()"> <img height="20px" border="1"
									width="80px" id="img_validation_code"
									src="servlet/validationCode.a" /></a>&nbsp;
						
							<a href="javascript:refresh();" style="font-size:12px; font-family:arial; text-decoration: none;">看不清?</a>
						</td>
						
					</tr>
					<tr height="40"  align="center">
						<td>&nbsp;</td>
						<td colspan="2">
							<input type="submit" value="&nbsp;确定&nbsp;" /> 
									 &nbsp;&nbsp; &nbsp;&nbsp;
							<input	type="reset" value="&nbsp;重置&nbsp;" />
						</td>
					</tr>
				</table>
			</form>
               </TD>
         </TR>
         </TABLE>

      </TD>
      </TR>
      </TABLE>
      </div>
      </BODY>
      </HTML>
