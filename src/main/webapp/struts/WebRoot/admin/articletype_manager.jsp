<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>文章类型列表</title>
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<link href="css/newstyle.css" rel="stylesheet" type="text/css" />
			<style type="text/css">
			
.div1{
position:absolute;
	width: 300px;
	height: 100px;
	margin-left:350px;
	margin-top:100px;
	border: solid;
	border-color: #bbbbbb;
	border-width: 1px;
	background: #dddddd;
	float:auto;
	display: none;
	z-index:10;
}


.main{
	position:absolute;
		width:100%;
	height:600px;
	filter: Alpha(Opacity = 80, FinishiOpacity = 20, Style =4, StartX = 0, StartY =
				0, FinishX = 1024, FinishY = 768);
	float:auto;
	background-color:#ffffff;
	
	z-index:8;
	font-size:14px;
}

.main2{
position:absolute;
width:100%;
height:100%;
float:auto;
z-index:5;
font-size:14px;

}
	

</style>

		<script language="JavaScript">
			var $a;
			var $b;
			var $tt;
		
			$(document).ready(function() {
		
				$('.edit').click(function() {
			
					$a = $(this).attr("title");
					$b = $(this).parent().prev().text();
					$tt = $(this).parent().prev();
		
					$('#articletypeid').attr('value', $a);
					$('#name').attr('value', $b);
					

					$(".div1").fadeIn();
					$("#main2").addClass("main2");
					$("#main").addClass("main");
					
				});
		
				$('#btn1').click(function() {
					//$('.div1').css("display","none");
						$b = $('#name').attr('value');
		
						//序列化表单的值
						var params = $('#form1').serialize();
					
						$.ajax( {
							//后台处理程序
							url : "updateArticletype",
							//数据发送方式
							type : "post",
							//接受数据格式
							dataType : "json",
							//要传递的数据
							data : params,
							//回传函数
							success : updateok
						});
					});
			});
		
			function updateok(result) {

				if (null != result) {
					alert("修改成功！");
					document.getElementById("divshow").style.display = "none";
					$("#main2").removeClass("main2");
					$("#main").removeClass("main");
					$("#show").css("display","none");
				}
				$tt.text($b);
			}
		
			function closeme() {
				document.getElementById("divshow").style.display = "none";
				$("#main2").removeClass("main2");
				$("#main").removeClass("main");
			}
	</script>

	

	</head>
	<body>
	
		<div id="main">
		</div>
	<div id="main2" class="main2">		
			<table width="60%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="40px">
						<a href="articletype_add.jsp"
							style="text-decoration: none; font-size: 12px;">--添加文章类型--</a>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#69a8d2">
							<tr>
								<td width="50%" height="25">
									<div align="center">
										<span class="STYLE10">文章类型</span>
									</div>
								</td>

								<td width="50%">
									<div align="center">
										<span class="STYLE10">基本操作</span>
									</div>
								</td>
							</tr>
							<s:iterator value="#request.all" id="articletype">
								<tr align="center">
									<td height="30" bgcolor="#FFFFFF" class="STYLE19">
										<s:property value="#articletype.name" />
									</td>
									<td height="30" bgcolor="#FFFFFF" >
										<a title="<s:property value="#articletype.articletypeid" />"
											href="#" class="edit">修改</a> |
										<a
											href="deleteArticletype?articletypeid=<s:property value='#articletype.articletypeid'/>"
											onclick="return confirm('你真的要删除吗?');">删除</a>
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</table>
</div>
	
			<!-- 用于显示修改类型的div -->
			<div id="divshow" class="div1">

				<s:form id="form1" name="form1" method="post">
					<table border="0" cellpadding="0" cellspacing="0" style="margin: 0;font-size: 14px;">
						<tr height="22px" style="background-image: url(images/d.gif)">
							<td align="left"  width="372">
								修改文章类型
							</td>
							<td width="20" bgcolor="#eceffa">
								<img style="cursor: pointer;" src="images/close.gif"
									width="28px" height="22px" onclick=
	closeme();;
/>
							</td>
						</tr>
					</table>
					<table align="center" border="0" cellpadding="0" cellspacing="3"
						style="margin-top: 15px; margin-left: 10px; font-size: 14px;">
						<tr>
							<td>
								<span class="STYLE10">文章类型:</span>
							</td>
							<td>
								<input type="hidden" name="articletypeid" id="articletypeid">
							</td>
							<td>
								<input type="text" class="type2" id="name" name="name" size="20" style="border: solid  1px inset;" />
							</td>
						</tr>
						<tr><td colspan="3">&nbsp;</td></tr>
						<tr>
							<td colspan="3" align="center">
								<input type="button" id="btn1" style="cursor: pointer;" value="修改">
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" style="cursor: pointer;" onclick="closeme()" value="取消"></td>
						</tr>

					</table>
				</s:form>
			</div>

	</body>
</html>

