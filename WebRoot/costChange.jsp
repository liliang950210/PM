<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <title>My JSP 'costChange.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/input.css" type="text/css">
	<script type="text/javascript">
		function  inputIsNull(form){
			with(form){
				if(addName.value==""){
					alert("请输入成本名称！");
					document.getElementById("input").focus();
					return false;
				}
			}
			return true;
		}
	</script>
  </head>
  
  <body>
  
  
 		<s:if test="costId==null">
  			<h2 align="center" >增加</h2>
  		</s:if>
 		<s:else>
  			<h2  align="center">修改</h2>
  		</s:else>
  <form action="${pageContext.request.contextPath}/updateCost.action"  onsubmit="return inputIsNull(this)">
  				
    	<table border="1" class="zebra" >
    	
  		<thead>
    		<tr>
    			<th>名称</th>
    			<th>金额</th>
    			<th>描述</th>
    		</tr>
    		</thead>
    		<tbody>
    		<tr>
    		
    			<td ><input name="addName"  style="width:100%;padding: -10px;" id="input" type="text" value="${addName }" ></td>
    			<td><input name="cost" type="text" style="width:100%;padding: 0px;" value="${ cost }" onkeyup="if(isNaN(value))execCommand('undo')" 
    			onafterpaste="if(isNaN(value))execCommand('undo')"></td>
    			<td><input name="desc"type="text" style="width:100%" value="${desc }"></td>
    		</tr>
    	</table>
    	</tbody>
    	<input type="hidden"  name="projectId" value="${projectId }">
   		<input type="hidden" name="costId" value="${costId }">
   		
   		<p align="right" style="margin-right: 20px;"><input type="submit" value="提交" ></p>
   		
  	</form>			
  				
  				
  				
    
  </body>
</html>
