<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	 		<title>添加主题</title>
	 			<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	
		  <script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>
		
		<script language="javascript">
			window.onload = function() {
					CKEDITOR.replace('contents');
					};
		
      		function check(){
      		    if (document.getElementById('title').value.replace(/\s/g,"")=="") {
                            alert("标题不能为空！");
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
		<form method="post" action="addBbs" onsubmit="return check();">
			<br>
			
						<input type="hidden" id="replycount" name="replycount" value="0" />
					
			<table width="800" align="center" cellpadding="0" cellspacing="1"   bgcolor="#acbfd9">
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9">
						主题：
					</td>
					<td>
					<input id="title" size="50" name="title"  style="border: solid 2px inset"/>
					</td>
				</tr>
				
				<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9">
						内容：
					</td>
					<td>
						<textarea id="contents" name="contents"></textarea>
					</td>
				</tr>

				<tr bgcolor="#acbfd9">
		<td colspan="2" height="35" align="center">
			<input type="submit" value="发表"  style="width:60px; height:25px; font-size:12px; border: solid 1px #666;"/>
		</td>
	</tr>
			</table>
		</form>

	</body>
</html>
