<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>上传代码</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	
</head>

<body>


<div id="content">

	
<center>
<fieldset style="border-width:5px;margin-left:50px" >
<legend align="left" style="color:#CDC8B1;width:140px">选择上传阶段代码</legend>
  <form action="${pageContext.request.contextPath}/upload.action" method="post" enctype="multipart/form-data" >         
        <span id="files" style="width:300px">          
                                         选择文件 ：<input type="file" name="upload"/><br/>           
            <br/>                            
        </span> 
        <span style="display:block; width:300px; text-align:right">  
        	<input type="submit" value="上传文件"/>
		</span>
     </form>
</fieldset>
</center>
<!-- 
	 <s:form action="upload。action" method="post" enctype="multipart/form-data" >         
        <span id="files">          
                                         选择文件 ：<s:file name="upload" label="上传的文件"/><br/>           
            <br/>                            
        </span>   
      	<s:submit value="上传文件"/>
      	<input type="button" onclick="addComponent();" value="添加文件"/>
     </s:form>
-->
</div>





<!-- 
<div id="footer">  copyright by shaojidui</div>
 -->


</div>


</body>
</html>