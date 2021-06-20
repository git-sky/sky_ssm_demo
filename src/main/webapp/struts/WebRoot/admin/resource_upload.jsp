<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>资源上传</title>
		<script language="javascript">
     		 function check(){
                if (document.getElementById('resourcename').value.replace(/\s/g,"") == "") {
                    alert("资源名称不能为空！");
                    return false;
                } else if (document.getElementById('instruction').value.replace(/\s/g,"") == "") {
                            alert("资源描述不能为空！");
                            return false;
                        }
                        else if (document.getElementById('file').value == "") {
                            alert("请选择要上传的资源！");
                            return false;
                        }
                return true;
            }
    </script>
    
	</head>
	<body>
		<s:fielderror />
		<s:form action="uploadResource?a=1" method="post"
			enctype="multipart/form-data" onsubmit="return check();">
			
					
			<input type="hidden" name="downcount" value="0" />
				
			
				<table width="800" align="center" cellpadding="0" cellspacing="1"   bgcolor="#acbfd9" style="font-size:14px;">
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						资源类型：</td><td>
						<s:select name="resourcetypeid" list="alltype"
							listKey="#request.resourcetypeid"
							listValue="#request.resourcetypename" theme="simple" />
					</td>
				</tr>
				<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						资源名称：</td><td>
						
						<input type="text" size="50" id="resourcename" name="resourcename" style="border: solid 2px inset"/>
					</td>
				</tr>

				<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">上传资源：</td><td>
			
					<s:file id="file" name="file" theme="simple" style="border: solid 2px inset"></s:file>
					<font color="red">*上传的资源必须在250M以下</font>
					</td>
				</tr>

			<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						资源描述：
						</td>
						<td>
					<textarea rows="5" cols="70" id="instruction" name="instruction" style="border: solid 2px inset"></textarea>
						
					</td>
				</tr>

							<tr bgcolor="#69a8d2">
		<td colspan="2" height="35" align="center">
			<input type="submit" value="上传"  style="width:60px; height:25px; font-size:12px; border: solid 1px #666;"/>
		</td>
	</tr>
			</table>
		</s:form>
	</body>
</html>

