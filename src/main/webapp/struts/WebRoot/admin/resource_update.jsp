<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>文章列表</title>
		<script language="javascript" type="text/javascript">
			function check(){
				if (document.getElementById('resourcename').value.replace(/\s/g,"") =="") {
					alert("资源名称不能为空！");
					return false;
				} else if (document.getElementById('instruction').value.replace(/\s/g,"") =="") {
					alert("资源说明不能为空！");
					return false;
				}
				return true;
			}
		</script>
		
	</head>

	<body>

		<center>
			<s:set name="resource" value="#request.resource">
			</s:set>
			<s:set name="resourcetype" value="#request.resourcetype">
			</s:set>
			
			<form action="updatesubmitResource" method="post" onSubmit="return check();">
			
					<input type="hidden" name="resourceid"
								value='<s:property value="#resource.resourceid" />' />
				
					<input type="hidden" name="page"
								value='<s:property value="#request.page" />' />
				
					<input type="hidden" name="userid"
								value='<s:property value="#resource.users.userid" />' />
					
					<input type="hidden" name="filename"
								value='<s:property value="#resource.filename" />' />
				
					<input type="hidden" name="sizes"
								value='<s:property value="#resource.sizes" />' />
			
					<input type="hidden" name="downcount"
								value='<s:property value="#resource.downcount" />' />
				

				<table width="800" align="center" cellpadding="0" cellspacing="1"   bgcolor="#acbfd9" style="font-size:14px;">
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9">
								资源类型：</td><td>
								<s:select name="resourcetypeid2" list="alltype"
									listKey="resourcetypeid" listValue="resourcetypename"
									value="#request.resourcetype.resourcetypeid"  theme="simple" />

						</td>
					</tr>

					<tr bgcolor="#ffffff"  height="30">
				 <td  align="center" bgcolor="#acbfd9">
							资源名称：</td><td>
							<input type="text" size="50" id="resourcename" name="resourcename"
								value='<s:property value="#resource.resourcename" />' style="border: solid 2px inset" />
						</td>
					</tr>
				<tr bgcolor="#ffffff"  height="30">
				 <td  align="center" bgcolor="#acbfd9">
						资源说明：</td><td>
						<textarea rows="5" cols="70" id="instruction" name="instruction"  style="border: solid 2px inset"><s:property value="#resource.instruction" /></textarea>
		
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
