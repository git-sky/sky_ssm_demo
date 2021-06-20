<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>添加试题</title>
		<script language="javascript">
      function check(){
                if (document.getElementById('title').value.replace(/\s/g,"") == "") {
                    alert("试题题目不能为空！");
                    return false;
                }
                    else 
                        if (document.getElementById('A').value.replace(/\s/g,"") == "") {
                            alert("选项A不能为空！");
                            return false;
                        }
                       else  if (document.getElementById('B').value.replace(/\s/g,"") == "") {
                            alert("选项B不能为空！");
                            return false;
                        }else  if (document.getElementById('C').value.replace(/\s/g,"") == "") {
                            alert("选项C不能为空！");
                            return false;
                        }        
                        else  if (document.getElementById('D').value.replace(/\s/g,"") == "") {
                            alert("选项D不能为空！");
                            return false;
                        }
               
                return true;
            }
    </script>
	</head>

	<body>

		<form method="post" action="addTestbank?param=1"
			onsubmit="return check();">
			<br>
		<table width="800" align="center" cellpadding="0"  border="1" bordercolor="#acbfd9" style="border-collapse:collapse; font-size:14px;">
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						章&nbsp;&nbsp;&nbsp;&nbsp;节：
					</td>
					<td>
						<s:select name="chapterid" list="alltype" listKey="#request.chapterid"
							listValue="#request.name" theme="simple" />
					</td>
				</tr>
			<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2" width="100">
						题&nbsp;&nbsp;&nbsp;&nbsp;目：
					</td>
					<td>
							<textarea rows="3" cols="80" id="title" name="title"  style="border: solid 2px inset"></textarea>
					</td>
				</tr>
				<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						选&nbsp;项&nbsp;A：
					</td>
					<td>
							<textarea rows="3" cols="80" id="A" name="A"  style="border: solid 2px inset"></textarea>
					</td>
				</tr>
				<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						选&nbsp;项&nbsp;B：
					</td>
					<td>
							<textarea rows="3" cols="80" id="B" name="B"  style="border: solid 2px inset"></textarea>
					</td>
				</tr>
				<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						选&nbsp;项&nbsp;C：
					</td>
					<td>
							<textarea rows="3" cols="80" id="C" name="C"  style="border: solid 2px inset"></textarea>
					</td>
				</tr>
			<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						选&nbsp;项&nbsp;D：
					</td>
					<td>
					<textarea rows="3" cols="80" id="D" name="D"  style="border: solid 2px inset"></textarea>
					</td>
				</tr>

				<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#69a8d2">
						正确答案：
					</td>
					<td><input name="answer" type="checkbox" value="A">A
						<input name="answer" type="checkbox" value="B">B
						<input name="answer" type="checkbox" value="C">C
						<input name="answer" type="checkbox" value="D">D
					</td>
					
				</tr>
				
			<tr bgcolor="#69a8d2">
				<td colspan="2" height="35" align="center">
					<input type="submit" value="添加"  style="width:60px; height:25px; font-size:12px; border: solid 1px #666;"/>
				</td>
			</tr>

			</table>
		</form>

	</body>