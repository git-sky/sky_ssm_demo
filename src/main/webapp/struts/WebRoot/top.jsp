<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>多媒体վ</title>
		
		<style type="text/css">
			.topA{
					width:100%;
					height:100px;
					background-image:url(images/topimage.gif);
					margin-top:0px;
					
				
			}
			
			.topB{	 
					width:100%;
					height:25px; 
					background-image:url(images/menubg.gif);
					text-decoration: none;
				
			}
			
			.topB a{
			font-size: 14px;
			color:white;
			text-decoration: none;
			}
			
			.topB a:hover{
			font-size: 14px;
			color:yellow;
			text-decoration: underline;
			}
					
	</style>
		
	</head>
	<body>

				<div class="top"><!--top-->
			
				<div class="topA">
			      <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="980" height="100" title="f">
                    <param name="movie" value="flash/1.swf">
                    <param name="quality" value="high">
                    <param name="wmode" value="transparent">
                    <embed src="flash/1.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="627" height="113"></embed>
		          </object>
			    </div>
				
				<div class="topB">
				<div style="text-align: center;">
					<table border="0" cellpadding="0" cellspacing="0" align="center"
							width="80%" height="100%">
					<tr>
					<td>
						<a href="index.action">网站首页</a>&nbsp;&nbsp;&nbsp;
					</td>
					<td>
						<a href="showallNews?condition=select">新闻资讯</a>&nbsp;&nbsp;&nbsp;
					</td>
					<td>
						<a href="showallArticle?condition=select" >课程学习</a>&nbsp;&nbsp;&nbsp;
					</td>
					<td>
						<a href="showallResource?condition=select">资源中心</a>&nbsp;&nbsp;&nbsp;
					</td>
					<td>
						<a href="showallChapter">在线测试</a>&nbsp;&nbsp;&nbsp;
					</td>
					<td>
						<a href="showallBbs?condition=select">论坛平台</a>
					</td>
				</tr>
				</table>
				  </div>	
				</div>
				
			</div><!-- top-->
			</body>

			</html>