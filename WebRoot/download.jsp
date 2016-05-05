<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>下载代码</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	
	<style type="text/css">

		.operation:link{color:#FFFFFF; text-decoration:none;}
        .operation:visited{color:#FFFFFF;text-decoration:none;} 
  	</style>
	
	
</head>

<body>


<div id="content">   
	<table class="zebra">
	<caption>个人版本列表</caption>
	<thead>
	<tr>
		<th>版本编号</th>
		<th>上传者姓名</th>
		<th>版本名称</th>
		<th>上传时间</th>
		<th>操作</th>
	</tr>
	</thead>

	<tbody>
	<c:forEach var="list" items="${sessionScope.list}">
	<tr >
		<td width="15%" align="left">${list.editionId}</td>
		<td width="15%" align="left">${list.userId}</td>
		<td width="40%" align="left">${list.personEditionPath}</td>
		<td width="20%" align="left">${list.personEditionTime}</td>
		<td width="10%" align="left"><a href="${pageContext.request.contextPath}/namespace/download.action" class="operation">下载</a>/<a href="#" class="operation">删除</a></td>
	
		    
			
	</tr>

	</c:forEach>
	</tbody>
</table>


</div>
    <!-- 
    <div id="footer">  copyright by shaojidui</div>
     -->
</body>
</html>