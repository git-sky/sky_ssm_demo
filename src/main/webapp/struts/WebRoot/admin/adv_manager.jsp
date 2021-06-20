<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>公告列表</title>
		<style type="text/css">
		a{
		text-decoration: none;
		}
		</style>
	</head>
	<body>
	
	
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30px">
			<a href="adv_add.jsp" style="text-decoration: none; font-size: 12px;" >--添加公告--</a>
		</td>
	</tr>	
  <tr>
    <td>
    
    <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#69a8d2" style="border-collapse: collapse; font-size: 12px; text-align: center;" >
	       <tr height="25" bgcolor="#69a8d2">
				<td width="70%">公告标题</td>
				<td width="15%">发表日期</td>
				<td width="15%">基本操作</td>
	      </tr>
	       <s:iterator value="#request.all" id="adv">
	      <tr height="30">
			<td align="left" >&nbsp;&nbsp;<a href="updateAdv?advid=<s:property value='#adv.advid'/>"><s:property
										value="#adv.title" /> </a>
			</td>
			<td><s:property value="#adv.date" /></td>
			<td><a href="updateAdv?advid=<s:property value='#adv.advid'/>">
									修改 </a> | 
				<a href="deleteAdv.action?advid=<s:property value='#adv.advid'/>"  onclick="return confirm('你真的要删除吗?');">删除</a> 
				
			</td>
		 </tr>
		 </s:iterator>
</table>

</td>
</tr>
</table>
			
</body>
</html>
