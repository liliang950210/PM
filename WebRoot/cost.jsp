<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib prefix="s" uri="/struts-tags" %>
    <base href="<%=basePath%>">
    
    <title>成本管理</title>
    
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
    <button onclick="window.location.href='${pageContext.request.contextPath }/changeCost.action?projectId=${projectId}'"  >添加</button>
    
   <div id="content">
    <table class="zebra">
    
    <caption> 成本管理</caption>
    <thead>
    <tr>
    	<th>名称</th>
    	<th>金额</th>
    	<th>描述</th>
    	<s:if test="roleId==1">
    	<th>操作</th>
    	</s:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${sessionScope.list}">
    		<tr>
    			<td  >${list.costItem}</td>
    			<td >${list.costExpense}</td>
    			<td >${list.costDescription}</td>
    			<s:if test="roleId==1">
    			<td >
    			<a href="${pageContext.request.contextPath}/deleteCost.action?projectId=${list.projectId}&costId=${list.costId}">删除</a>
    			
    			<a  href="${pageContext.request.contextPath }/changeCost.action?addName=${list.costItem }&cost=${list.costExpense}&desc=${list.costDescription}
    				&projectId=${list.projectId}&costId=${list.costId}">更新</a>
    				</td>
    			</s:if>
    		</tr>
    </c:forEach  >
    </tbody>
    </table>
   </div>
    <!--注释掉这部分内容 
    <form action="${pageContext.request.contextPath}/addCost.action" method="get">
    	<table border="1" >
    		<tr>
    			<th>名称</th>
    			<th>金额</th>
    			<th>描述</th>
    			
    		</tr>
    		<tr>
    			<td><input name="addName" type="text"></td>
    			<td><input name="cost" type="text"></td>
    			<td><input name="desc"type="text"></td>
    			
    		</tr>
    		<tr>
    			<td><input type="submit" value="提交" >
    			
    		</td>
    	</table>
    </form>
    
    <form action="${pageContext.request.contextPath }/updateCost.action">
    	请输入更新的内容：<br>
    	<table border="1" >
    		<tr>
    			<th>名称</th>
    			<th>金额</th>
    			<th>描述</th>
    		</tr>
    		<tr>
    			<td><input name="addName" type="text"></td>
    			<td><input name="cost" type="text"></td>
    			<td><input name="desc"type="text"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="提交" >
    			
    		</td>
    	</table>
    	
    </form>
    	 -->
 
  </body>
</html>
