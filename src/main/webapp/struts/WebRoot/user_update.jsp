<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>用户列表</title>
			    <script language="javascript">
     	 function check(){
                if (document.getElementById('pass').value.replace(/\s/g,"") == "") {
                            alert("密码不能为空！");
                          
                            return false;
                        } else 
                            if (document.getElementById('pass').value.replace(/\s/g,"").length<6|| document.getElementById('pass').value.replace(/\s/g,"").length>10) {
                                alert("密码必须在6-10个字符之间！"); 

                                alert(document.getElementById('pass').value.replace(/\s/g,""));
                                alert(document.getElementById('pass2').value.replace(/\s/g,""));
                                return false;
                               
                            }
                        else 
                            if (document.getElementById('pass2').value.replace(/\s/g,"")!= document.getElementById('pass').value.replace(/\s/g,"")) {
                                alert("两次输入的密码不一致！");
                                return false;
                            }
                            else 
                                if (document.getElementById('question').value.replace(/\s/g,"").length<1) {
                                    alert("密码问题不能为空！");
                                    return false;
                                }
                                else 
                                    if (document.getElementById('answer').value.replace(/\s/g,"").length<1) {
                                        alert("问题答案不能为空！");
                                        return false;
                                    }
                            else 
                                if (document.getElementById('email').value == "") {
                                    alert("eamil不能为空！");
                                    return false;
                                }
                                else 
                                    if (document.getElementById('qq').value.length<6) {
                                        alert("qq号位数太少！");
                                        return false;
                                    }
                
                var s = document.getElementById('email').value;
                var pattern = /^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z]{1,}$/;
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
    input{
    border: solid 1px inset;
    }
    </style>
	</head>
	<body>
		<center>
			<s:set name="user" value="#request.user"></s:set>
				<form action="updatesubmitUser" onsubmit="return check();" method="post">
			
					<input type="hidden" name="page"
							value='<s:property value="#request.page" />' />
					
					<input type="hidden" id="userid"  name="userid"
								value="<s:property value="#user.userid"/>">
								
					<input type="hidden" id="mark"  name="mark"
							value="<s:property value="#user.mark"/>">
							
							<input type="hidden" id="date"  name="date"
							value="<s:property value="#user.date"/>">
									
				<table width="60%" border="1" bordercolor="#9fb7e7" style="border-collapse: collapse;font-size: 12px;">
					<tr height="25" bgcolor="#9fb7e7"><th colspan="2" align="center" >用户修改</th></tr>
					
					<tr height="30">
						<td align="right" width="40%">
							用户名：
						</td>
						<td>
							<input type=text id="username" name="username"
								value="<s:property value="#user.username"/>" readonly="readonly">
						</td>
					</tr>
							<tr height="30">
						<td align="right" >
							密码：
						</td>
						<td>
							<input type="password" id="pass" name="pass"
								value=<s:property value="#user.pass"/>>
						</td>
					</tr>
							<tr height="30">
						<td align="right" >
							密码确认：
						</td>
						<td>
							<input type="password" id="pass2" name="pass2"
								value=<s:property value="#user.pass"/>>
						</td>
					</tr>

							<tr height="30">
						<td align="right">
	
							性别：
						
						</td>
						<td>
						<s:if test='#user.sex=="男"'>
							<input type="radio" name="sex" value="男" checked="checked">男
							<input type="radio" name="sex" value="女" />女
							</s:if>
						<s:elseif test='#user.sex=="女"'>
							<input type="radio" name="sex" value="男" >男
							<input type="radio" name="sex" value="女" checked="checked">女
							</s:elseif>
							
						</td>
					</tr>
							<tr height="30">
						<td align="right" >
							密码问题：
						</td>
						<td>
							<input type=text id="question" name="question"
								value=<s:property value="#user.question"/>>
						</td>
					</tr>		
							<tr height="30">
						<td align="right">
							问题答案：
						</td>
						<td>
							<input type=text id="answer" name="answer"
								value=<s:property value="#user.answer"/>>
						</td>
					</tr>
						<tr height="30">
						<td align="right">
							电子邮件：
						</td>
						<td>
							<input type=text id="email" name="email"
								value=<s:property value="#user.email"/>>
						</td>
					</tr>
							<tr height="30">
						<td align="right">
							QQ号：
						</td>
						<td>
							<input type=text id="qq" name="qq" value=<s:property value="#user.qq"/>>
						</td>
					</tr>
							<tr height="30">
						<td colspan="2" align="center">
						<input type="submit" value="修改" style="width:50px; height:20px; font-size:12px; border: solid 1px #666;"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"  style="width:50px; height:20px; font-size:12px; border: solid 1px #666;"/>
					
					</td>
					</tr>

			</table>
				</form>


		</center>
	</body>
</html>