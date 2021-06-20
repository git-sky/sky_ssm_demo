<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%if (null==session.getAttribute("user")){
	response.sendRedirect("login.jsp");
	
} %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/all.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		
		<script type="text/javascript">
		
		$(document).ready(function(){
				$("#gen").click(function(){
					var params = $('#form1').serialize();
					
					$.ajax( {
						//后台处理程序
						url : "generateTestbank",
						//数据发送方式
						type : "post",
						//接受数据格式
						dataType : "json",
						//要传递的数据
					data : params,
						//回传函数
						success : generate
					});

				});

				function generate(result){
				var tests=result.tests;
			//	alert(tests.length);
				if(tests.length>0){
				$(".results").html("");
				$.each(tests,function(i,test){
					$(".results").append("<table width='98%' style='border:dashed 1px #cccccc'><tr height='40'><td>第"+(i+1)+"题:</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;"+test.title+"</td></tr><tr  height='40'><td>供选择的答案:</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;A:<input name="+test.testid+" type='checkbox' value='A'>"+test.a+"</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;B:<input name="+test.testid+" type='checkbox' value='B'>"+test.b+"</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;C:<input name="+test.testid+" type='checkbox' value='C'>"+test.c+"</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;D:<input name="+test.testid+" type='checkbox' value='D'>"+test.d+"</td></tr></table>");
					});
				$(".results").append("<table width='98%' style='border:dashed 1px #cccccc'><tr height='40'><td align='center'><input id='sub' type='button' value='我要交卷' /></td></tr></table>");	
				}else{
					$(".results").html("<table width='98%' style='font-size:14px; color:red;'><tr><td align='center'>数据库中没有足够的试题数目！</td></tr></table>");
				}

				}


				$("#sub").live("click",function(){
					//alert("sub");
					var params = $('#form2').serialize();
					$.ajax( {
						//后台处理程序
						url : "handinTestbank",
						//数据发送方式
						type : "post",
						//接受数据格式
						dataType : "json",
						//要传递的数据
					data : params,
						//回传函数
						success : myscore
					});

				});

				function myscore(data){
					var grade=data.grade;
					$(".results").html("");
					$(".results").append("<table width='98%' style='font-size:14px; color:red;'><tr><td align='center'>你的成绩是："+grade+"分</td></tr></table>");	
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

		<div>
			<form id="form1" action="" style="margin: 0px;">
				<table width=100%  style="font-size: 12px;background-color: #a2b8ec;color:#333333;" align="center">
					<tr>
						<td align="center">
							章节:
									<s:select name="chapterid" list="alltype"
										listKey="chapterid" listValue="name"
												theme="simple" cssStyle="height:20px;" />
							&nbsp;&nbsp;题数:<select name="num">
							<option value="10">&nbsp;10&nbsp;</option>
							<option value="20">&nbsp;20&nbsp;</option>
							<option value="30">&nbsp;30&nbsp;</option>
							</select>				
										<!-- 把请求的页传过去 -->
										
							<input id="gen" type="button" value="抽题"  style="width:50px; height:20px; font-size:12px; border: solid 1px #22479d; background-color: #f0f0f0; color:#000000;"/>
						</td>
						<td width="200px" style="color: #ff4444;">*注意：试卷满分是30分</td>
					</tr>
				</table>
			</form>
		</div>	
	<div  style="border: solid 1px #9fb7e7;">
		<form id="form2" action="" method="post">
			<table align="center" height="300"  width="90%" style="font-size: 14px">
				<tr>
					<td align="center"  class="results">
					
					请选择要考试的章节和所考的题数
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
