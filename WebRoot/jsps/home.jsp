<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'home.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="../css/style.css" type="text/css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<!-- <iframe allowTransparency="true" src="test.html"></iframe>  -->

	<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
    	<frame src="./frames/head.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame"/>
    	<frameset cols="15%,*" frameborder="no" border="0" framespacing="0">
    		<frame src="./frames/leftmenu.html" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame"/>
    		<frame src="./viewScope.action?projectId=1" name="content" id="mainFrame"/>
<!-- 
<frameset cols="120,*">

	<frame src="./htmls/Menu.html" noresize="noresize">
	<frame src="./viewScope.action?projectId=1" name="content">

</frameset>
 -->
<body>


</body>


</html>
