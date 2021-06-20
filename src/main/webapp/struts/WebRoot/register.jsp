<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
		<link href="css/all.css" rel="stylesheet" type="text/css" />
		
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
			//	alert("cccccccc");
				//alert("params);
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
					if (null==result.checkname) {

						$("#username").css("border","solid green 1px");
						$("#username").parent().parent().next().first().children().first().find("span").remove().end().append("<span>用户名可用 </span>").css("color","green");
					
					}else{
						$("#username").css("border","solid red 1px");
						$("#username").parent().parent().next().first().children().first().find("span").remove().end().append("<span>用户名已被占用 </span>").css("color","red");
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

				if($(this).val().search("^-?\\d+$") != 0)
			{
					$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>qq格式不正确</span>").css("color","red");
				}
				else if($.trim($(this).val()).length<6)
				{
				$(this).css("border","solid red 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span class='flag'>qq号位数太少</span>").css("color","red");
				}
				else{
					$(this).css("border","solid green 1px");
					$(this).parent().parent().next().first().children().first().find("span").remove().end().append("<span>填写正确 </span>").css("color","green");
				}
			});
			
			$("#reg").click(function(){
				
				$("form :input").trigger("blur");
				
				if($(".flag").length<1){
							
				//$("form:first").trigger("submit");
				
				var datas= $('#forms').serialize();

					$.ajax( {
						//后台处理程序
						url : "addReg",
						//数据发送方式
						type : "post",
						//接受数据格式
						dataType : "json",
						//要传递的数据
					data : datas,
						//回传函数
						success : registerok
					});
				}
			});
				
			function registerok(result) {
			if(null==result.error){
				window.location.href="user.jsp";
			}
			else{
					$("#error").html("<font color='red' size='3'>"+result.error+"</font>");
				}
			
			}		
			
		});
		
		</script>

	</head>
	<body>
		<div class="top">
		<jsp:include page="common.jsp"></jsp:include>
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div class="all">
			<table align="center" width="80%">
				<tr>
					<td align="center">
						<form method="post" id="forms">
						
							<input type="hidden" id="mark" name="mark" value="0" />
							
							<table width="80%" border="0" align="center" cellpadding="0"
								cellspacing="0" style="font-size: 12px; border: solid 1px #CCCCCC;">


								<tr style="background-color:#bad3e2;" align="center">
									<td height="25" colspan="3" class="STYLE3">
										<div align="center">
											用户注册
										</div>
									</td>
								</tr>
								<tr><td colspan="3" id="error">&nbsp;</td></tr>
								
								<tr bgcolor="#FFFFFF">
									<td width="200" height="35" align="right">
										<div align="right">
											用户名称:&nbsp;&nbsp;
										</div>
									</td>

									<td height="35" width="150">
										<div align="left">
											<input type="text" id="username" name="username"
												style="width: 200px; height: 25px; font-size: 12px; border: solid 1px #ccc;" />&nbsp;
										</div>
									</td>
									<td>
										<div>
										
										</div>
									</td>
								</tr>

								<tr bgcolor="#FFFFFF">
									<td width="200" align="right">
										<div align="right">
											&nbsp;&nbsp;&nbsp;&nbsp;密码:&nbsp;&nbsp;
										</div>
									</td>
									<td  height="35">
										<div align="left">
											<input type="password" id="pass" name="pass"
												style="width: 200px; height: 25px; font-size: 12px; border: solid 1px #ccc;" />
										</div>
									</td>
									<td>
										<div align="left" id="pass0">
									
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td align="right">
										<div align="right">
											密码确认:&nbsp;&nbsp;
										</div>
									</td>
									<td  height="35">
										<div align="left">
											<input type="password" id="pass2" name="pass2"
												style="width: 200px; height: 25px; font-size: 12px; border: solid 1px #ccc;" />
										</div>
									</td>
									<td>
										<div align="left">
										</div>
									</td>
								</tr>

								<tr bgcolor="#FFFFFF"  height="35">
									<td align="right">
										<div align="right">
											&nbsp;&nbsp;&nbsp;&nbsp;性别:&nbsp;&nbsp;
										</div>
									</td>
									<td>
										<div align="left">
											<input type="radio" name="sex" value="男" checked="checked" />
											男
											<input type="radio" name="sex" value="女" />
											女

										</div>
									</td>
									<td>
										<div align="left">
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF"  height="35">
								<td align="right">
										<div align="right">
											密码问题:&nbsp;&nbsp;
										</div>
									</td>
									<td  height="35">
										<div align="left">
											<input type="text" id="question" name="question"
												style="width: 200px; height: 25px; font-size: 12px; border: solid 1px #ccc;" />
										</div>
									</td>
									<td>
										<div align="left">
										
										</div>
									</td>
								</tr>

								<tr bgcolor="#FFFFFF">
									<td align="right">
										<div align="right">
											问题答案:&nbsp;&nbsp;
										</div>
									</td>
									<td height="35">
										<div align="left">
											<input type="text" id="answer" name="answer"
												style="width: 200px; height: 25px; font-size: 12px; border: solid 1px #ccc;" />
										</div>
									</td>
									<td>
										<div align="left">
											
										</div>
									</td>
								</tr>

								<tr bgcolor="#FFFFFF">
									<td align="right">
										<div align="right">
											电子邮件:&nbsp;&nbsp;
										</div>
									</td>
									<td height="35">
										<div align="left">
											<input type="text" id="email" name="email"
												style="width: 200px; height: 25px; font-size: 12px; border: solid 1px #ccc;" />
										</div>
									</td>
									<td>
										<div align="left">
											
										</div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td align="right">
										<div align="right">
											&nbsp;&nbsp;&nbsp;&nbsp;QQ号:&nbsp;&nbsp;
										</div>
									</td>
									<td height="35">
										<div align="left">
											<input type="text" id="qq" name="qq"
												style="width: 200px; height: 25px; font-size: 12px; border: solid 1px #ccc;" />
										</div>
									</td>
									<td>
									<div> </div>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td colspan="3" height="35" >
										<div align="center">
											<input type="button" id="reg" value="注册"
												style="width: 50px; height: 25px; font-size: 12px; border: solid 1px #666;" />
										</div>
									</td>
								</tr>

							</table>

						</form>
					</td>
				</tr>
			</table>
		</div>
		<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
