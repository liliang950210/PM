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
    <title>My JSP 'resourcesChange.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/input.css" type="text/css">
	
	
	</style>
		<script type="text/javascript">
			function inputIsNull(form){
				with(form){
					if(name.value==""){
						alert("请填写资源名字！");
						document.getElementById("name").focus();
						return false;
					}
				}
				return true;
			}
		</script>
  </head>
  
  <body>
 	<s:if test="resourceId==null">
    		<h2  align="center">增加</h2>
    	</s:if>
    	<s:else>
    		<h2  align="center">修改</h2>
   		</s:else>
    
    <form action="${pageContext.request.contextPath}/updateResources.action" onsubmit="return inputIsNull(this)">
     	<table border="1" class="zebra">
     	
   		<thead>
     		<tr>
     			<th>名称</th>
     			<th>分类</th>
     			<th>数量</th>
     			<th>描述</th>
     		</tr>
     		</thead>
     		<tbody>
     		<tr class="unknow">
     			<td><input name="name"  id="name" style="width:100%" type="text" value="${name }"></td>
     			<td><select name="type" style="width:100%" >
     				<s:if test="resourceId!=null">
	     				<s:if test="type==0">
		     				<option value="0"  selected="selected">硬件</option>
		     				<option value="1">软件</option>
		     				<option value="2">人力</option> 
	     				</s:if>
	     				<s:elseif test="type==1">
	     					<option value="0"  >硬件</option>
		     				<option value="1" selected="selected">软件</option>
		     				<option value="2">人力</option> 
	     				</s:elseif>
	     				<s:else>
	     					<option value="0"  >硬件</option>
		     				<option value="1">软件</option>
		     				<option value="2" selected="selected">人力</option> 
	     				</s:else>
	     				
     				</s:if>
     				<s:else>
	     				<option value="0"  selected="selected">硬件</option>
	     				<option value="1">软件</option>
	     				<option value="2">人力</option> 
     				</s:else>
     			</select>
     			</td>
     			<td><input name="quantity" type="text" value="${quantity }" style="width:100%" onkeyup="this.value=this.value.replace(/\D/g,'')" 
     			onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
     			<td><input name="desc" type="text"style="width:100%" value="${desc }"></td>
     		</tr>
     		</tbody>
     	</table>
     	<input type="hidden" name="resourceId" value="${resourceId }">
     	<input type="hidden" name="projrctId" value="${projectId }">
     	
     	<p  align="right" style="padding-right: 20px;"><input type="submit" value="提交"></p>
    </form>
  </body>
</html>
