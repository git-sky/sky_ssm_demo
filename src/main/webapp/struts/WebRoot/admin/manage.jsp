<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title></title>
	
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/menu.js"></script>
		<link type="text/css" rel="stylesheet" href="css/menu.css" />
	</head>
	<body style="margin:1px">
		<div style="width:160px; font-size: 14px; background-color: #ffeeee;">
		
			<ul class="main" id="main">
				<li>
					<a class="head">基本管理</a>
					<ul>
						<li>
							<a href="updateAdmin" target="rightFrame">修改密码</a>
						</li>
						<li>
							<a href="showallCount" target="rightFrame">网站统计</a>
						</li>
						<li>
							<a href="showallAdv" target="rightFrame">公告管理</a>
						</li>
					</ul>
				</li>
				<li style="height:5px;"></li>
				<li>
					<a class="head">用户管理</a>
					<ul>
						<li>
							<a href="showallUser?condition=select" target="rightFrame">用户管理</a>
						</li>
						<li>
							<a href="user_add.jsp" target="rightFrame">添加用户</a>
						</li>
					</ul>
				</li>
				<li style="height:5px;"></li>
				<li>
					<a class="head">新闻管理</a>
					<ul>
						<li>
							<a href="showallNews?condition=select" target="rightFrame">新闻管理</a>
						</li>
						<li>
							<a href="news_add.jsp" target="rightFrame">添加新闻</a>
						</li>
					</ul>
				</li>
				<li style="height:5px;"></li>
				<li>
					<a class="head">文章管理</a>
					<ul>
						<li>
							<a href="showallArticletype" target="rightFrame">文章类型管理</a>
						</li>
						
						<li>
							<a href="showallArticle?condition=select" target="rightFrame">管理文章</a>
						</li>
						<li>
							<a href="addArticle.action" target="rightFrame">添加文章</a>
						</li>
					</ul>
				</li>
				<li style="height:5px;"></li>
				<li>
					<a class="head">资源管理</a>
					<ul>
					<li>
							<a href="showallResourcetype" target="rightFrame">资源类型管理</a>
						</li>
						<li>
							<a href="showallResource?condition=select" target="rightFrame">管理资源</a>
						</li>
						<li>
							<a href="uploadResource" target="rightFrame">上传资源</a>
						</li>
					</ul>
				</li>
				<li style="height:5px;"></li>
				<li>
					<a class="head">留言管理</a>
					<ul>
						<li>
							<a href="bbs_add.jsp" target="rightFrame">发表主题</a>
						</li>
						<li>
							<a href="showallBbs?condition=select" target="rightFrame">管理留言</a>
						</li>
					</ul>
				</li>
				<li style="height:5px;"></li>
				<li>
					<a class="head">试题管理</a>
					<ul>
					<li>
							<a href="showallChapter" target="rightFrame">章节管理</a>
						</li>
						<li>
							<a href="showallTestbank?condition=select" target="rightFrame">试题管理</a>
						</li>
						<li>
							<a href="addTestbank" target="rightFrame">添加试题</a>
						</li>
					</ul>
				</li>
				<li style="height:5px;"></li>
				<li>
					<a class="head">退出管理</a>
					<ul>
						<li>
							<a href="logout.jsp" onclick="return confirm('你真的要退出吗?')" target="_top">安全退出</a>
						</li>

					</ul>
				</li>
			</ul>
		</div>
		
	</body>
</html>
