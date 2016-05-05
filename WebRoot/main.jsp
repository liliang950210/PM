<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<style type="text/css">
div#container{width:auto;background-color:#36648B; margin: -8px;}
div#header {text-align: left; margin-top: -30px; margin-left:13px; height: 70px; }

.headmenu{text-align: right; border-top: solid 1px #6CA6CD;}
.headmenu ul{ display: inline-block;margin-right: 20px; margin-top: 0px;margin-bottom: 0px;}
.headmenu li{ color:#CDC8B1; float: left; list-style: none;padding:5px; border:#CDC8B1; cursor: pointer;font-size: 16px;}
.headmenu li:HOVER{background-color: #36648B}
.headmenu li + li {margin-left: 20px }

.leftmenu {background-color:#6E7B8B; height:600px; width:13%; float:left;margin-left:13px;}
.leftmenu ul {list-style: none; }
.leftmenu li {text-align:center; color:#CDC8B1; font-size: 20px;letter-spacing: 5px;margin-bottom: 10px; margin-left: -40px;cursor: pointer;}
.leftmenu li:HOVER{background-color: #36648B;}

div#content {background-color:#EEEEEE; height:600px; width:85%; float:left;}

div#footer {background-color:#6CA6CD; clear:both; text-align:center;float: bottom;}
</style>
</head>

<body>

<div id="container">

<div id="header">
<h2 style=" padding-top:15px; color:#F8F8FF; font-size:35px; font-family:宋体">IT项目管理系统</h2>

</div>
<div class="headmenu">
<ul >
	<li >管理已加入项目</li>
	<li>创建新项目</li>
	<li>修改资料</li>
	<li>退出</li>
</ul>
</div>

<div class="leftmenu">

<ul>
	<li>人员分工</li>
	<li>范围说明</li>
	<li>时间安排</li>
	<li onclick="window.location.href='getCost.action'">预计成本</li>
	<li onclick="window.location.href='getResources.action'">项目资源</li>
	<li><a href="upload.jsp">代码管理</a></li>
	<li>已有版本</li>
</ul>
</div>

<div id="content">Content goes here</div>
<div id="footer">  copyright by shaojidui</div>



</div>


</body>
</html>