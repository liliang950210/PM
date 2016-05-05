<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<link rel="stylesheet" href="css/style.css" type="text/css">
  </head>
  
  <body>
  
  <form action="${pageContext.request.contextPath}/confirmScope.action" method="post">
  
 	<h1>范围启动</h1>
 	<input type="text" value="${projectScope.scopeStart}" name="projectScope.scopeStart"/>
 	
	<br />
	<h1>范围计划</h1>
 	<input type="text" value="${projectScope.scopePlan}" name="projectScope.scopePlan"/>
	<br />
	<h1>范围定义</h1>
 	<input type="text" value="${projectScope.scopeDefinition}" name="projectScope.scopeDefinition"/>
	<br />
	<h1>范围确定</h1>
 	<input type="text" value="${projectScope.scopeConfirm}" name="projectScope.scopeConfirm"/>
	<br />
	<h1>范围变更</h1>
 	<input type="text" value="${projectScope.scopeChange}" name="projectScope.scopeChange"/>

	<br />
	<input type="hidden" name="projectScope.projectId" value="${projectScope.projectId}"/>
	<input type="hidden" name="projectScope.scopeId" value="${projectScope.scopeId}"/>
	<input type="submit" value="确认修改"/>  
  </form>
  
  
  </body>
</html>
