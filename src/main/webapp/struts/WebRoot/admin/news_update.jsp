<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>新闻修改</title>
		
    <script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>
		
		<script language="javascript">
			window.onload = function() {
					CKEDITOR.replace('contents');
					};
		
      		function check(){
               if (document.getElementById('title').value.replace(/\s/g,"") == "") {
                            alert("标题不能为空！");
                            return false;
                        } else if(document.getElementById('source').value.replace(/\s/g,"") == ""){
                        	alert("来源不能为空！");
                            return false;
                        }
                else if (CKEDITOR.instances.contents.getData()=="") {
                    alert("内容不能为空！");
                    return false;
                }
           return true;
            }
          </script>
	</head>

	<body>

		<center>

			<form action="updatesubmitNews" method="post" onsubmit="return check();">
				<s:set name="news" value="#request.news" />
					<input type="hidden" name="page"
								value='<s:property value="#request.page" />' />
							
							<input type="hidden" id="readcount" name="readcount"
								value='<s:property value="#news.readcount" />' />
					
				<table width="800" align="center" cellpadding="0"  border="1" bordercolor="#acbfd9" style="margin-top:50px; border-collapse:collapse; font-size:14px;">

	<tr bgcolor="#ffffff"  height="30">
						<td  align="center" bgcolor="#acbfd9">
							新闻标题</td><td>
							<input type="text" size="50" id="title" name="title"
								value='<s:property value="#news.title" />' style="border: solid 2px inset"/>
						</td>
					</tr>
					<tr bgcolor="#ffffff"  height="30">
						<td  align="center" bgcolor="#acbfd9">
							新闻来源</td><td>
							<input type="text" size="50" id="source" name="source"
								value='<s:property value="#news.source" />' style="border: solid 2px inset" />
						</td>
					</tr>
					
					<tr>
						<td  align="center" bgcolor="#acbfd9">
							新闻内容</td>
						<td>
							<textarea name="contents">${news.contents }</textarea>

						</td>
					</tr>
				<tr bgcolor="#acbfd9">
					<td colspan="2" height="35" align="center">
			<input type="submit" value="修改"  style="width:60px; height:25px; font-size:12px; border: solid 1px #666;"/>
					</td>
					</tr>
				</table>
			</form>

		</center>
	</body>
</html>
