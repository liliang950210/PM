<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>

<body>
	查看范围页面
	<br>
	<h1>范围启动</h1>
	<br />
	<p>${projectScope.scopeStart}</p>
	<h1>范围计划</h1>
	<br />
	<p>${projectScope.scopePlan}</p>
	<h1>范围定义</h1>
	<br />
	<p>${projectScope.scopeDefinition}</p>
	<h1>范围确定</h1>
	<br />
	<p>${projectScope.scopeConfirm}</p>
	<h1>范围变更</h1>
	<br />
	<p>${projectScope.scopeChange}</p>

<br/>

<s:if test="roleId==1">
<a href="${pageContext.request.contextPath}/changeScope.action?projectId=${projectScope.projectId}">
修改范围
</a>
</s:if>

</body>
</html>
