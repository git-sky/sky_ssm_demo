<%@ page language="java" import="java.util.*,entity.*" pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE7 {font-size: 12px; color: #FFFFFF;}

.STYLE7 a{font-size: 12px; color: #FFFFFF; text-decoration:none; }

</style>
<script type="text/javascript" src="js/Clock.js"></script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr height="50">
  <td>
	  <table width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td style="background-image: url(images/middle.jpg);">&nbsp;</td>
		   	<td width="520" style="background-image: url(images/lmr.gif);"></td>
		   	<td style="background-image: url(images/middle.jpg);">&nbsp;</td>
		  </tr>
	    </table>
    </td>
  </tr>
  <tr height="35">
    <td style="background-image: url('images/mid.png');" align="center">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
	          <tr>
	           <td width="20">&nbsp;</td>
	          	<td width="180" class="STYLE7"><div align="left">欢迎&nbsp;&nbsp;&nbsp;<font color="blue"><%=((Users)session.getAttribute("admin")).getRoles().getRolename()%><%=((Users)session.getAttribute("admin")).getUsername()%></font>&nbsp;&nbsp;&nbsp;光临</div></td>
	          	<td  class="STYLE7"><marquee direction="left" behavior="scroll" scrollamount="3" width="800">欢迎管理员登录!</marquee></td>
	            <td width="250"  class="STYLE7"><span id="clock"></span></td>
	          
	          </tr>
	        </table>
	        
    </td>
  </tr>
</table>
 <SCRIPT type="text/javascript">
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</SCRIPT>
</body>
</html>
