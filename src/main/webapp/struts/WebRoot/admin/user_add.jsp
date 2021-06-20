<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>

		<title>添加用户</title>
		<style type="text/css">
.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 14px;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
</style>

	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		
		<script type="text/javascript">
		var b;
		$(document).ready(function(){
			$("#username").blur(function(){

			if($.trim($(this).val()).length<6||$.trim($(this).val()).length>10)
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>用户名必须在6-10个字符之间</span>").css("color","red");
				}else{

					b = $('#username').attr('value');
					//序列化表单的值
				var params = $('#username').serialize();
				
					$.ajax( {
						//后台处理程序
						url : "checkReg",
						//数据发送方式
						type : "post",
						//接受数据格式
						dataType : "json",
						//要传递的数据
					data : params,
						//回传函数
						success : updateok
					});
				}
				function updateok(result) {

					if (null==result.username) {

						$("#username").css("border","solid green 1px");
						$("#username").parent().parent().next().first().children().first().find("span").remove().end().append("<span>用户名可用 </span>").css("color","green");
					
					}else{
						$("#username").css("border","solid red 1px");
						$("#username").parent().parent().next().first().children().first().find("span").remove().end().append("<span>该用户名已被占用 </span>").css("color","red");
					}
				}
			});

			$("#pass").blur(function(){
				if($.trim($(this).val()).length<6||$.trim($(this).val()).length>10)
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>密码必须在6-10个字符之间</span>").css("color","red");
				}
				else{
					$(this).css("border","solid green 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span>填写正确 </span>").css("color","green");
				}
				
			});
			
			$("#pass2").blur(function(){
				if($.trim($(this).val()).length<6||$.trim($(this).val()).length>10)
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>确认密码必须在6-10个字符之间</span>").css("color","red");
				}else if($(this).val()!=$("#pass").val())
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>确认密码与密码不一致</span>").css("color","red");
				}
				else{
					$(this).css("border","solid green 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span>填写正确 </span>").css("color","green");
				}
				
			});

			
			$("#question").blur(function(){
				if($.trim($(this).val()).length<1)
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>问题不能为空</span>").css("color","red");
				}
				else{
					$(this).css("border","solid green 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span>填写正确 </span>").css("color","green");
				}
				
			});
			
			$("#answer").blur(function(){
				if($.trim($(this).val()).length<1)
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>答案不能为空</span>").css("color","red");
				}
				else{
					$(this).css("border","solid green 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span>填写正确 </span>").css("color","green");
				}
				
			});
			
			$("#email").blur(function(){
				var e=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
				if(!e.test($(this).val()))
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>email格式不正确</span>").css("color","red");
				}
				else{
					$(this).css("border","solid green 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span>填写正确 </span>").css("color","green");
				}
				
			});

			$("#qq").blur(function(){
				if($.trim($(this).val()).length<6){
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>qq位数太短</span>").css("color","red");
					}
				else if($(this).val().search("^-?\\d+$") != 0)
				{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>qq格式不正确</span>").css("color","red");
				}
				else{
					$(this).css("border","solid green 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span>填写正确 </span>").css("color","green");
				}
			});
			
			$("#reg").click(function(){
				
				$("form :input").trigger("blur");
			//	alert($(".flag").length);
				if($(".flag").length<1){
				$("form:first").trigger("submit");
				}
			});
			
		});
		
		</script>


		<script language="javascript">
      function check(){
                if (document.getElementById('username').value.replace(/\s/g,"") == "") {
                    alert("用户名不能为空！");
                    return false;
                }
                    else 
                        if (document.getElementById('pass').value.replace(/\s/g,"") == "") {
                            alert("密码不能为空！");
                            return false;
                        }
                        else 
                            if (document.getElementById('pass2').value.replace(/\s/g,"") != document.getElementById('pass').value.replace(/\s/g,"")) {
                                alert("两次输入的密码不一致！");
                                return false;
                            }
                            else 
                                if (document.getElementById('question').value.replace(/\s/g,"") == "") {
                                    alert("密码问题不能为空！");
                                    return false;
                                }
                                else 
                                    if (document.getElementById('answer').value.replace(/\s/g,"") == "") {
                                        alert("问题答案不能为空！");
                                        return false;
                                    }
                            else 
                                if (document.getElementById('email').value.replace(/\s/g,"") == "") {
                                    alert("eamil不能为空！");
                                    return false;
                                }
                                else 
                                    if (document.getElementById('qq').value.replace(/\s/g,"") == "") {
                                        alert("qq号不能为空！");
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

	</head>

	<body>
		<form method="post" action="addUser" onsubmit="return check();">
<input type="hidden" id="mark" name="mark" value="0"/>
			<table width="60%"  align="center" cellpadding="0"
				cellspacing="0" style="font-size:12px; border: solid 1px #69a8d2;">

				<tr bgcolor="#69a8d2">
					<td height="25" colspan="3"
						 class="STYLE3">
						<div align="center">
							用户添加
						</div>
					</td>
				</tr>
							<tr bgcolor="#FFFFFF">
								<td width="200" height="35" class="STYLE1"  align="right">
									<div>
										用户名称:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>

								<td width="200" height="35" class="STYLE1">
									<div align="center">
										<input type="text" id="username" name="username"
											style="width:200px; height:25px; font-size:12px; border:solid 1px #ccc;"/>
        							</div>
        						</td>
        						<td>
        							<div>
        							</div>
        						</td>
							</tr>
							
							<tr bgcolor="#FFFFFF">
								<td  height="35" class="STYLE1" align="right">
									<div>
									&nbsp;&nbsp;&nbsp;&nbsp;密码:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<td width="200" height="35" class="STYLE1">
									<div align="left">
										<input type="password" id="pass" name="pass"
											style="width:200px; height:25px; font-size:12px; border:solid 1px #ccc;" />&nbsp;&nbsp;&nbsp;&nbsp;
        							</div>
        						</td>
        						<td>
        							<div align="left">
        						
        							</div>
        						</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td  height="35" class="STYLE1" align="right">
									<div>
									密码确认:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<td width="200" height="35" class="STYLE1">
									<div align="left">
										<input type="password" id="pass2" name="pass2"
											style="width:200px; height:25px; font-size:12px; border:solid 1px #ccc;" />&nbsp;&nbsp;&nbsp;&nbsp;
        							</div>
        						</td>
        						<td>
        							<div align="left">
        							
        							</div>
        						</td>
							</tr>
							
							<tr bgcolor="#FFFFFF">
								<td  height="35" class="STYLE1" align="right">
									<div>
									&nbsp;&nbsp;&nbsp;&nbsp;性别:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<td  width="200" height="35" class="STYLE1">
								<div align="left">
									<input type="radio" name="sex" value="男" checked="checked" />
									男
									<input type="radio" name="sex" value="女" />
									女
								
								</div>
								</td>
								<td>
        							
        						</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td  height="35" class="STYLE1" align="right">
									<div>
									密码问题:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<td width="200" height="35" class="STYLE1">
									<div align="left">
										<input type="text" id="question" name="question"
											style="width:200px; height:25px; font-size:12px; border:solid 1px #ccc;" />&nbsp;&nbsp;&nbsp;&nbsp;
       								 </div>
       							</td>
       							<td>
        							<div align="left">
        						
        							</div>
        						</td>
							</tr>
							
							<tr bgcolor="#FFFFFF">
								<td  height="35" class="STYLE1" align="right">
									<div>
									问题答案:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<td width="200" height="35" class="STYLE1">
									<div align="left">
										<input type="text" id="answer" name="answer"
											style="width:200px; height:25px; font-size:12px; border:solid 1px #ccc;" />&nbsp;&nbsp;&nbsp;&nbsp;
        							</div>
        						</td>
        						<td>
        							<div>
        						
        							</div>
        						</td>
							</tr>
							
							<tr bgcolor="#FFFFFF">	
								<td  height="35" class="STYLE1" align="right">
									<div>
										电子邮件:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<td width="200" height="35" class="STYLE1">
									<div align="left">
										<input type="text" id="email" name="email"
											style="width:200px; height:25px; font-size:12px; border:solid 1px #ccc;" />&nbsp;&nbsp;&nbsp;&nbsp;
							        </div></td>
							        <td>
        							<div align="left">
        					
        							</div>
        						</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td  height="35" class="STYLE1" align="right">
									<div>
										&nbsp;&nbsp;&nbsp;&nbsp;QQ号:&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<td width="200" height="35" class="STYLE1">
									<div align="left">
										<input type="text" id="qq" name="qq"
											style="width:200px; height:25px; font-size:12px; border:solid 1px #ccc;" />&nbsp;&nbsp;&nbsp;&nbsp;
       								 </div></td>
       								 <td>
        							<div align="left">
        				
        							</div>
        						</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td colspan="3" height="35"  class="STYLE1">
								<div align="center">
									<input type="button" id="reg" value="添加" style="width:50px; height:25px; font-size:12px; border: solid 1px #666;"/>
									&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"  style="width:50px; height:25px; font-size:12px; border: solid 1px #666;"/>
									</div>
								</td>
							</tr>
							
						</table>
				
		</form>


	</body>
</html>
