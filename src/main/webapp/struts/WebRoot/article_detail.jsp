<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title></title>
		<link href="css/all.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
		<s:set name="article" value="#request.article"/>
	
			<table border="0" cellspacing="10" cellpadding="2" width="90%" align="center"  style="background-color: #fafafa;">
		
			<tr height="50px" style="font-size: 24px;color:#429ec0" align="center"><td><s:property value="#article.title" /></td></tr>
			<tr height="40px" align="center">
				<td><table style=" border-top: solid 1px #cccccc;font-size: 12px; color: #777777; " height="100%" width="60%"><tr align="center"><td>
						章节:
							<s:property value="#article.articletype.name" />
							&nbsp;&nbsp;
						日期:<s:property value="#article.date" />
						&nbsp;&nbsp;
						阅读数:<s:property value="#article.readcount" />
						</td></tr></table>
				</td>
			</tr>
			
			<tr>
				<td>
			${article.contents}
				</td>
			</tr>		

			
    </table>
    </div>
    
	<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
