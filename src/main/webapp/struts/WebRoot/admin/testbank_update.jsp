<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>修改试题</title>
		<script language="javascript" type="text/javascript">
			window.onload=aa;
			
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
                        else  if (document.getElementById('D').value.replace(/\s/g,"")== "") {
                            alert("选项D不能为空！");
                            return false;
                        }
               
                return true;
            }
	
	function aa(){
		alert(document.getElementById('hid').value);
		var datastr = document.getElementById('hid').value;
		var str=new Array();
	     //此处分割符必须是逗号加空格，否则分割不对。
	  	str=datastr.split(", "); 
	      
	    for (var ii=0;ii<str.length ;ii++ )    
	    {    
	       var data=str[ii];
	       alert(data); 
	   	alert(ii);  
	   alert(data+data);
	      document.getElementById(data+data).checked=true;
	     
	    
		    }
	    }    
	
</script>
	</head>

	<body>

		<center>
			<s:set name="testbank" value="#request.testbank">
			</s:set>

			<s:set name="chapter" value="#request.chapter">
			</s:set>

			<input type="hidden" id="hid" name="answer"
				value='<s:property value="#testbank.answer" />' />

			<form action="updatesubmitTestbank" method="post" onSubmit="return check();">

							<input type="hidden" name="page"
								value='<s:property value="#request.page" />' />
					
		<table width="800" align="center" cellpadding="0"  border="1" bordercolor="#acbfd9" style="border-collapse:collapse; font-size:14px;">
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9">
							试题章节</td><td>
							<s:select name="chapterid2" list="alltype"
								listKey="#request.chapterid" listValue="#request.name"
								value="#request.chapter.chapterid"  theme="simple" />
						</td>
					</tr>

					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9" width="100">
							试题题目</td><td>
								<textarea rows="3" cols="80" id="title" name="title"  style="border: solid 2px inset"><s:property value="#testbank.title" /></textarea>
						</td>
					</tr>
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9" width="100">
							选项A</td><td>
								<textarea rows="3" cols="80" id="A" name="A"  style="border: solid 2px inset"><s:property value="#testbank.A"/></textarea>
						
						</td>
					</tr>
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9" width="100">
							选项B</td><td>
							<textarea rows="3" cols="80" id="B" name="B"  style="border: solid 2px inset"><s:property value="#testbank.B"/></textarea>
						</td>
					</tr>
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9" width="100">
							选项C</td><td>
							<textarea rows="3" cols="80" id="C" name="C"  style="border: solid 2px inset"><s:property value="#testbank.C"/></textarea>
						</td>
					</tr>
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9" width="100">
							选项D</td><td>
						<textarea rows="3" cols="80" id="D" name="D"  style="border: solid 2px inset"><s:property value="#testbank.D"/></textarea>
						</td>
					</tr>
					<tr bgcolor="#ffffff"  height="30">
					 <td  align="center" bgcolor="#acbfd9">
						正确答案：
					</td>
					<td><input name="answer" type="checkbox" value="A" id="AA">A
						<input name="answer" type="checkbox" value="B" id="BB">B
						<input name="answer" type="checkbox" value="C" id="CC">C
						<input name="answer" type="checkbox" value="D" id="DD">D
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
     