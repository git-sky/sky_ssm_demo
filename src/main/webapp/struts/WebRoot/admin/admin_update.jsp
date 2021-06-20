<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>修改信息</title>
		    <script language="javascript">
      function check(){
                if (document.getElementById('username').value == "") {
                    alert("用户名不能为空！");
                    return false;
                }
                    else 
                        if (document.getElementById('pass').value == "") {
                            alert("密码不能为空！");
                            return false;
                        }
                        else 
                            if (document.getElementById('pass2').value != document.getElementById('pass').value) {
                                alert("两次输入的密码不一致！");
                                return false;
                            }
                            else 
                                if (document.getElementById('email').value == "") {
                                    alert("eamil不能为空！");
                                    return false;
                                }
                                else 
                                    if (document.getElementById('qq').value.length<6) {
                                        alert("qq号位数太短！");
                                        return false;
                                    }
                
                var s = document.getElementById('email').value;
                var pattern = /^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/;
                if (s != "") {
                    if (!pattern.exec(s)) {
                        alert('请输入正确的邮箱地址');
                        return false;
                    }
                    
                }
                
                var q = document.getElementById('qq').value;
                for (var i = 0; i < q.length; i++) {
                    if (isNaN(q)) {
                        alert("qq号格式不正确！");
                        return false;
                    }
                }

                return true;
            }
    </script>
    
    <style type="text/css">
    .style1{
    font-size:14px;
    }
    tr{
    font-size: 12px;

    }
    </style>
		
	</head>
	<body>
		<center>
		<form method="post" action="updatesubmitAdmin" onsubmit="return check();">
				<s:set name="admin" value="#request.admin" />
					
				<input type="hidden" name="userid" value='<s:property value="#admin.userid" />'/>	
				
			<table width="60%" border="0" cellspacing="0" cellpadding="0"  style="border:solid 1px #69a8d2">
				
				<tr height="25"><td colspan="2" align="center" bgcolor="#69a8d2" ><div class="style1">管理员修改</div></td>
				</tr>

				<tr bgcolor="ffffff" height="30">
					<td align="right" width="40%" >
						管理员：
					</td>
					<td>
						<input type="text" id="username" name="username"  style="width: 150px" value='<s:property value="#admin.username" />'>
					</td>
				</tr>
				<tr bgcolor="ffffff" height="30">
					<td align="right" >
						密&nbsp;&nbsp;码：
					</td>
					<td>
						<input type="password" id="pass" name="pass"  style="width: 150px" value='<s:property value="#admin.pass" />'>
					</td>
				</tr>
					<tr bgcolor="ffffff" height="30">
					<td align="right">
						密码确认：
					</td>
					<td>
						<input type="password" id="pass2" name="pass2"  style="width: 150px" value='<s:property value="#admin.pass" />'>
					</td>
				</tr>
				<tr bgcolor="ffffff" height="30">
					<td align="right">

						性&nbsp;&nbsp;别：
					
					</td>
					<td>
					<s:if test='#admin.sex=="男"'>
						<input type="radio" name="sex" value="男" checked="checked">男
						<input type="radio" name="sex" value="女" />女
						</s:if>
					<s:elseif test='#admin.sex=="女"'>
						<input type="radio" name="sex" value="男" >男
						<input type="radio" name="sex" value="女" checked="checked">女
						</s:elseif>
						
					</td>
				</tr>
				
					<tr bgcolor="ffffff" height="30">
					<td align="right">
						电子邮件：
					</td>
					<td>
						<input type="text" id="email" name="email"  style="width: 150px" value='<s:property value="#admin.email"/>'>
					</td>
				</tr>
				<tr bgcolor="ffffff" height="30">
					<td align="right">QQ号：</td>
					<td>
						<input type="text"  id="qq" name="qq"  style="width: 150px" value='<s:property value="#admin.qq" />'>
					</td>
				</tr>
					<tr bgcolor="ffffff" height="30">
					<td colspan="2" align="center" height="30">
						<input type="submit" value="修改"  style="width:60px; height:25px; font-size:12px; border: solid 1px #666;"/>
					</td>
				</tr>
			</table>
</form>
		</center>
	</body>
</html>