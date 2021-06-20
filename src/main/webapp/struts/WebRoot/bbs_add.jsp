<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>发表主题</title>
    <script language="javascript">
      function check(){
                if (document.getElementById('title').value == "") {
                    alert("主题不能为空！");
                    return false;
                }
                      else 
                        if (document.getElementById('contents').value == "") {
                            alert("内容不能为空！");
                            return false;
                        }
               
                return true;
            }
    </script>
    
 <link href="css/all.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
	<div class="top">
	<jsp:include page="common.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class="all">
 
   <form method="post" action="addBbs" onsubmit="return check();">
   <input type="hidden" name="condition" value="select"/>
     <table width="80%" height="25px" bgcolor="#a2b8ec"  style="color: #333333; font-size: 14px; margin-top: 10px;"><tr align="center"><td>&nbsp;&nbsp;&nbsp;&nbsp;发表主题</td></tr></table>
   	   <table width="80%"  align="center"  style="border: solid 2px #9fb7e7;vertical-align: center; margin-top: 0px; font-size: 12px;">
		<tr align="center"><td width="50px">主题：</td><td width="300px" align="left"><input type="text" id="title" name="title" size="50" /></td></tr>
		<tr align="center"><td></td><td><input type="hidden"id="replycount" name="replycount" value="0"/></td></tr>
		<tr align="center"><td>内容：</td><td align="left"><textarea  id="contents" name="contents" cols="80" rows="10"></textarea></td></tr> 
		<tr align="center"><td colspan="2"><input type="submit" value="发表"/></td></tr>
	</table>
	</form>
		</div>
		<div class="bottom">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
</body>
</html>
