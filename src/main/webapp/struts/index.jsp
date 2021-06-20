<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>

		<title>多媒体教学网站</title>
		
		<style type="text/css">
			.main{
					position:absolute;
					width:980px;
					background-color:white;
					left:50%;
					margin-left:-490px;
					margin-top:0px;
					font-size: 14px;
					
			}
			
			.header{	
					position:relative;
					width:980px;
					height:120px;
					margin:0px;
					margin-left: auto;
					margin-right:auto;
				
			}
			
			.content{

			position: relative;
			font-size: 12px;
			width: 980px;
			margin-left: auto;
			margin-right: auto;
			text-decoration: none;
			border:solid 1px  #9fb7e7;
			clear: left;
				font-size: 14px;

					
			}
			
			.contentLeft{
			position:relative;
			height:100%;
			width:180px;
			float:left;

			}
			

			.indexLeft{
				 background-image:url(images/tbg.gif); 
				 height:28px; 
				 width:180px; 
				 text-align:center; 
				 vertical-align:middle;
				 line-height:28px;
				 color: #333333; 
				 font-size: 12px; 
				 font-weight: bold;
			}
				
			.contentRight{
			position:relative;
			width:790px;
			font-size: 14px;
			margin-top: 5px;
			float: right;
			}
	
			.topA{
					position:relative;
					width:980px;
					height:100px;
					background-image: url(images/topimage.gif);
					text-decoration: none;
				
			}
			
			.topB{	 
					position:relative;
					width:980px;
					height:25px; 
					background-image:url(images/menubg.gif);
					font-size: 14px;
					text-align: center;
				}

			.footer{
					position: relative;
					width: 980px;
					height: 80px;
					border-top: solid 1px #9fb7e7;
					left: 50%;
					margin-top:10px;
					margin-left: -490px;
					text-align: center;
					text-decoration: none;
					font-size:12px;
					color:#143788;
					clear:left;
				}
		
		.bottom a{
		text-decoration: none;
		}
	
		a{
			text-decoration: none;
			color:#143788;
			font-size: 12px;
		}
		a:hover{
		text-decoration:underline;
		color:#000000;
		font-size: 12px;
		
		}
		
		.topB a{
		text-decoration:none;
		color:white;
		font-size: 14px;
		}
		
		.topB a:hover{
		text-decoration:underline;
		color:yellow;
		font-size: 14px;
		}
		
		</style>
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
	<div class="main">
		<div class="header" >
		<jsp:include page="../common.jsp"></jsp:include>
					<div class="topA">
					  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="980" height="100" title="f">
                        <param name="movie" value="flash/1.swf">
                        <param name="quality" value="high">
						  <param name="wmode" value="transparent">
                        <embed src="flash/1.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="980" height="100"></embed>
				      </object>
					</div>
					<div class="topB">
						<table border="0" cellpadding="0" cellspacing="0" align="center"
							width="80%" height="100%">
							<tr>
								<td>
									<a href="index.html">网站首页</a>
								</td>
								<td>
									<a href="showallNews?condition=select">新闻资讯</a>
								</td>
								<td>
									<a href="showallArticle?condition=select" >课程学习</a>
								</td>
								<td>
									<a href="showallResource?condition=select">资源中心</a>
								</td>
								<td>
									<a href="showallChapter">在线测试</a>
								</td>
								<td>
									<a href="showallBbs?condition=select">论坛平台</a>
								</td>
								
							</tr>
						</table>

					</div>
			
	  </div>
			<div class="content" id="content">	
			
				<div class="contentLeft">
					<div style="border:solid 1px #F2D483; height: 150px; width: 180px; margin-left: 2px; margin-top: 5px;">
						<div class="indexLeft">
					用户登录
						</div>
						<form  method="post" action="userLogin" onSubmit="return checkvalid();">
							<%if (null==session.getAttribute("user")){ %>
							<table height="100%" align="center">
								<tr height="20">
									<td><font size="2">用户名:</font></td>
									<td><input type="text" id="name" name="name" style="width:100px;"/></td>
								</tr>
								<tr height="20">
									<td><font size="2">密&nbsp;&nbsp;&nbsp;&nbsp;码:</font></td>
									<td><input type="password" id="password" name="password" style="width:100px;"/></td>
								</tr>
								<tr height="20">
									<td><font size="2">验证码:</font></td>
								<td><input type="text" id="validationCode" name="validationCode" style="width:100px;"/></td>
								</tr>
								<tr height="20">
										<td colspan="2" align="right">
											<a href="javascript:refresh()" >
											<img height="20px" width="80px" border="1" id="img_validation_code" src="servlet/validationCode.a"/></a>
										<a href="javascript:refresh()" style="text-decoration:none; font-size: 12px">看不清?</a></td>
						   	   </tr>			
								<tr height="20">
									<td colspan="2" align="center"><font size="2"><input type="submit" style="width:50px; height:20px; font-size:12px; border: solid 1px #666;" value="&nbsp;登录&nbsp;"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" style="width:50px; height:20px; font-size:12px; border: solid 1px #666;" value="&nbsp;取消&nbsp;"/></font></td>
								</tr>
								<tr height="20">
									<td colspan="2"><a href="register.jsp" >注册新用户</a>&nbsp;&nbsp;<a href="forget.jsp">忘记密码？</a></td>
								</tr>
							</table>
							
							<%}else { %>
							
							<table  align="center" style="font-size: 14px;">
								<tr height="30">
									<td>用户名:<s:property value="#session.user.username" /></td>
								</tr>
							<tr height="30">
								<td>
									<a href="user.jsp" >我的空间</a>
								</td>
							</tr>
							<tr height="30">
								<td>
									<a href="logout.jsp" onClick="return confirm('你真的要退出吗?');"> 注销登录</a>
								</td>
								</tr>
							</table>
							
							<%} %>
							
							
						</form>
						</div>
								
					<div style="border:solid 1px #F2D483; height: 150px; width: 180px; margin-left: 2px; margin-top: 5px;">
						<div class="indexLeft">
					最新公告
						</div>
						<marquee direction="up" height="166px" scrollamount="2" loop="-1" behavior="scroll" onMouseOver="this.stop();" onMouseOut="this.start();">
								<div style="margin-left: 20px;  height:166px;"><jsp:include page="../adv_rec.jsp"></jsp:include></div>
							</marquee>
					</div>
					
					<div style="border:solid 1px #F2D483; height: 150px; width: 180px; margin-left: 2px; margin-top: 5px;">
						<div class="indexLeft">
					网站统计
						</div>
							<jsp:include page="../count.jsp"></jsp:include>
					</div>
				</div><!--contentleft结束--->
				
				<div class="contentRight">
					<table width="100%" border="0" cellspacing="0" align="center">
						
						<tr height="250">
							<td width="50%" align="left">
								<table width="99%" height="99%" cellpadding="0" cellspacing="0" border="0" style="border: solid 1px #A2B8EC; ">
									<tr height="24" style="background-image:url(images/titlebg.gif) ;font-size: 12px; color: #113faf; font-weight: bold;">
										<td colspan="2">&nbsp;&nbsp;<img src="images/ico_1.gif" width="8px"/>&nbsp;&nbsp;最新文章</td>
										<td align="right"><a href="showallArticle?condition=select">更多</a>&nbsp;&nbsp;</td>
									</tr>
									<tr>
									
										<td colspan="2" style="vertical-align: top;"><jsp:include page="../article_rec.jsp"></jsp:include></td>
										<td>&nbsp;</td>
									</tr>
								</table>
							</td>
							<td width="50%" align="right">
				
								<table width="99%" height="99%" cellpadding="0" cellspacing="0" border="0" style="border: solid 1px #A2B8EC; ">
									<tr height="24" style="background-image:url(images/titlebg.gif) ;font-size: 12px; color: #113faf; font-weight: bold;">
										<td colspan="2">&nbsp;&nbsp;<img src="images/ico_1.gif" width="8px"/>&nbsp;&nbsp;最新资讯</td>
										<td align="right"><a href="showallNews?condition=select">更多</a>&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td colspan="2" style="vertical-align: top;"><jsp:include page="../news_rec.jsp"></jsp:include></td>
										<td>&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr height="250">
							<td width="50%">
				
							<table width="99%" height="99%" cellpadding="0" cellspacing="0" border="0" style="border: solid 1px #A2B8EC; ">
									<tr height="24" style="background-image:url(images/titlebg.gif) ;font-size: 12px; color: #113faf; font-weight: bold;">
										<td colspan="2">&nbsp;&nbsp;<img src="images/ico_1.gif" width="8px"/>&nbsp;&nbsp;最新资源</td>
										<td align="right"><a href="showallResource?condition=select">更多</a>&nbsp;&nbsp;</td>
								</tr>
								<tr>
									<td colspan="2" style="vertical-align: top;"><jsp:include page="../resource_rec.jsp"></jsp:include></td>
									<td>&nbsp;</td>
								</tr>
							</table>
					 	</td>
					
						<td width="50%" align="right">
				
								<table width="99%" height="99%" cellpadding="0" cellspacing="0" style="border: solid 1px #A2B8EC; ">
								<tr height="24" style="background-image:url(images/titlebg.gif) ;font-size: 12px; color: #113faf; font-weight: bold;">
									<td colspan="2">&nbsp;&nbsp;<img src="images/ico_1.gif" width="8px"/>&nbsp;&nbsp;最新主题</td>
									<td align="right"><a href="showallBbs?condition=select">更多</a>&nbsp;&nbsp;</td>
								</tr>
								<tr>
									
									<td colspan="2" style="vertical-align: top;"><jsp:include page="../bbs_rec.jsp"></jsp:include></td>
									<td></td>
								</tr>
							</table>
					 	</td>
					 
					 </tr>
				</table>
				</div><!--contentRight结束-->
			</div><!--content结束-->
	
			<div class="footer">
					<div style="width: 100%;height: 100%">
						<div style="margin:5px; cursor:hand; text-decoration:none;width: 100%;text-align: center;">
										<a href="#">关于我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;									
										<a href="#">联系我们 </a>&nbsp;&nbsp;|&nbsp;&nbsp;									
										<a href="#">加入我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;
										<a href="#">合作伙伴</a>&nbsp;&nbsp;|&nbsp;&nbsp;
										<a href="#">下载声明</a>&nbsp;&nbsp;|&nbsp;&nbsp;									
										<a href="#">广告服务 </a>&nbsp;&nbsp;|&nbsp;&nbsp;									
										<a href="#">服务声明</a>&nbsp;&nbsp;|&nbsp;&nbsp;									
										<a href="#">友情网站 </a>
								
						</div>
				<div style="margin: 5px;">
					Copyright&copy;2009 多媒体技术教学网.All rights
						reserved.冀ICP备002号
				</div>
				</div>
				</div>
				</div>
	</body>
</html>