<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="s" uri="/struts-tags" %>
    <title>My JSP 'resources.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/style.css" type="text/css">
  </head>
  
  <body>
    
    
    <button onclick="window.location.href='${pageContext.request.contextPath}/changeResources.action?projectId=${projectId}'">增加</button>
    <br>
  	
  	
  	 <div id="content">
    <table border="1" class="zebra">
    <caption>人力资源</caption>
    <thead>
    <tr>
    	<th>名字</th>
    	<th>数量</th>
    	<th>描述</th>
    	<s:if test="roleId==1">
    	<th>操作</th>
    	</s:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="res" items="${sessionScope.list0 }">
    	<tr>
    		<td>${res.resourceName}</td>
    		<td>${res.resourceQuantity }</td>
    		<td>${res.resourceDescription }</td>
    		<s:if test="roleId==1">
    		<td><a href="${pageContext.request.contextPath}/deleteResources.action?resourceId=${res.resourceId}&projectId=${res.projectId}">删除</a>/
    		<a href="${pageContext.request.contextPath}/changeResources.action?resourceId=${res.resourceId}&name=${res.resourceName}&desc=
    		${res.resourceDescription}&quantity=${res.resourceQuantity}&type=${res.resourceType}&projectId=${res.projectId}">修改</a>
    		</td>
    		</s:if>
    	</tr>
    </c:forEach>
    </tbody>
    </table>
    <br>
    <br>
    
    <table border="1" style="margin-top: 40px;" class="zebra">
    <caption>软件资源</caption>
    <thead>
    <tr>
    	<th>名字</th>
    	<th>数量</th>
    	<th>描述</th>
    	<s:if test="roleId==1">
    	<th>操作</th>
    	</s:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="res" items="${sessionScope.list1 }">
    	<tr>
    		<td>${res.resourceName}</td>
    		<td>${res.resourceQuantity }</td>
    		<td>${res.resourceDescription }</td>
    		<s:if test="roleId==1">
    		<td><a href="${pageContext.request.contextPath}/deleteResources.action?resourceId=${res.resourceId}&projectId=${res.projectId}">删除</a>/
    		<a href="${pageContext.request.contextPath}/changeResources.action?resourceId=${res.resourceId}&name=${res.resourceName}&desc=
    		${res.resourceDescription}&quantity=${res.resourceQuantity}&type=${res.resourceType}&projectId=${res.projectId}">修改</a>
    		</td>
    		</s:if>
    	</tr>
    </c:forEach>
    </tbody>
    </table><br><br>
   
    <table border="1"  style="margin-top: 40px;" class="zebra">
    <caption>硬件资源</caption>
    <thead>
    <tr>
    	<th>名字</th>
    	<th>数量</th>
    	<th>描述</th>
    	<s:if test="roleId==1">
    	<th>操作</th>
    	</s:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="res" items="${sessionScope.list2 }">
    	<tr>
    		<td>${res.resourceName}</td>
    		<td>${res.resourceQuantity }</td>
    		<td>${res.resourceDescription }</td>
    		<s:if test="roleId==1">
    		<td><a href="${pageContext.request.contextPath}/deleteResources.action?resourceId=${res.resourceId}&projectId=${res.projectId}">删除</a>/
    		<a href="${pageContext.request.contextPath}/changeResources.action?resourceId=${res.resourceId}&name=${res.resourceName}&desc=
    		${res.resourceDescription}&quantity=${res.resourceQuantity}&type=${res.resourceType}&projectId=${res.projectId}">修改</a>
    		</td>
    		</s:if>
    	</tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    <!--<form action="${pageContext.request.contextPath}/addResources.action">
     	<table border="1">
     		<tr>
     			<th>名称</th>
     			<th>分类</th>
     			<th>数量</th>
     			<th>描述</th>
     		</tr>
     		<tr>
     			<td><input name="name"  type="text"></td>
     			<td><select name="type" >
     				<option value="0" selected="selected">硬件</option>
     				<option value="1">软件</option>
     				<option value="2">人力</option> 
     			</select>
     			</td>
     			<td><input name="quantity" type="text"></td>
     			<td><input name="desc" type="text"></td>
     		</tr>
     	</table>
     	<input type="submit" value="增加">
    </form>
    删除资源：<br>
    <form action="${pageContext.request.contextPath}/deleteResources.action">
    <table border="1">
    <tr>
    	<th>名称</th>
    	<th>类型</th>
    </tr>
    <tr>
    			<td><input name="name"  type="text"></td>
     			<td><select name="type" >
     				<option value="0" selected="selected">硬件</option>
     				<option value="1">软件</option>
     				<option value="2">人力</option> 
     			</select>
     			</td>
     </tr>
    
    </table>
    <input type="submit" value="删除">
    </form>
    更新资源：<br>
    <form action="${pageContext.request.contextPath}/updateResources.action">
     	<table border="1">
     		<tr>
     			<th>名称</th>
     			<th>分类</th>
     			<th>数量</th>
     			<th>描述</th>
     		</tr>
     		<tr>
     			<td><input name="name"  type="text"></td>
     			<td><select name="type" >
     				<option value="0" selected="selected">硬件</option>
     				<option value="1">软件</option>
     				<option value="2">人力</option> 
     			</select>
     			</td>
     			<td><input name="quantity" type="text"></td>
     			<td><input name="desc" type="text"></td>
     		</tr>
     	</table>
     	<input type="submit" value="更新">
    </form>
    -->
  </body>
</html>
