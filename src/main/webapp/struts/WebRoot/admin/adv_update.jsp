<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>公告修改</title>
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

	<s:set name="adv" value="#request.adv" />
			<form action="updatesubmitAdv" method="post" onsubmit="return check();">
								
					<tr>
						<td colspan="2">
							<input type="hidden"  id="advid" name="advid"
								value='<s:property value="#adv.advid" />' />
						</td>
					</tr>
				<table width="800" align="center" cellpadding="0"  border="1" bordercolor="#acbfd9" style="margin-top:50px; border-collapse:collapse; font-size:14px;">

					<tr bgcolor="#ffffff"  height="30">
					
						<td width="100" align="center" bgcolor="#acbfd9">
							公告标题
							</td>
							<td>
							<input type="text" size="50" id="title" name="title"
								value='<s:property value="#adv.title" />'  style="border: solid 2px inset"/>
							</td>
					</tr>

					<tr bgcolor="#ffffff">
						<td  align="center" bgcolor="#acbfd9">
					
							公告内容</td>
						<td>
							<textarea name="contents">${adv.contents}</textarea>
						</td>
					</tr>
						<tr bgcolor="#acbfd9">
								<td colspan="2" height="35" align="center">
									<input type="submit" value="修改"  style="width:60px; height:25px; font-size:12px; border: solid 1px #666;"/>
								</td>
						</tr>
				</table>
			</form>

	</body>
</html>
