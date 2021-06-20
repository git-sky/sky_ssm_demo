<%@ page language="java" import="java.util.*,entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title></title>
		
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/menu.js"></script>
		<link type="text/css" rel="stylesheet" href="css/menu.css" />
	</head>
	<body  style="margin:1px">

			<div style="width:160px; font-size: 14px">
					<ul class="main" id="main">
						<li>
							<a class="head">我的资源</a>
							<ul>
								<li>
									<a  href="showmyResource"   target="myframe">查看我的资源</a>
								</li>
								<li>
									<a href="uploadResource" target="myframe">上传资源</a>
								</li>
								<li>
								</li>
							</ul>
						</li>
						<li height="5"></li>
						<li>
							<a class="head">我的考试</a>
							<ul>
								<li>
									<a href="showallScore" target="myframe">查看考试记录</a>
								</li>
								<li>
									<a href="showallChapter" target="_self">我要考试</a>
								</li>
								<li>
									
								</li>
							</ul>
						</li>
						<li height="5"></li>
						<li>
							<a class="head" >我的主题</a>
							<ul>
								<li>
									<a href="showmyBbs?condition=select" target="_self">查看我的主题</a>
								</li>
								<li>
									<a href="bbs_add.jsp" target="_self">发表主题</a>
								</li>
								<li>
								</li>
							</ul>
						</li>
						<li height="5"></li>
						<li>
							<a class="head" >我的信息</a>
							<ul>
								<li>
									<a href="updateUser" target="myframe">个人信息修改</a>
								</li>
								<li>
								
								</li>
								<li>
								
								</li>
							</ul>
						</li>
						<li height="5"></li>
						<li>
						<a class="head" href="logout.jsp" target="_top">安全退出</a>
						</li>
					</ul>
		</div>

	</body>
</html>