<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>

	<h1>查看任务安排</h1>
	<s:if test="roleId==1">
		<a href="./addTask.action?projectId=${projectId}&taskId=${taskId}">添加</a>

	</s:if>
	<br />
	<br />
	<table border="1" class="zebra" >
		<thead>
			<tr>
				<th>任务计划</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>持续时间</th>
				<th>负责人</th>
				<s:if test="roleId==1">
					<th>操作</th>
				</s:if>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="taskBeans" id="tasks">
			<tbody>
				<tr>
					<th><s:property value="#tasks.taskPlan" /></th>
					<th><s:property value="#tasks.startTime" /></th>
					<th><s:property value="#tasks.endTime" /></th>
					<th><s:property value="#tasks.lastedTime"/></th>
					<th><s:property value="#tasks.user.username" /></th>

					<s:if test="roleId==1">
						<td><a
							href="${pageContext.request.contextPath}/addTask.action?projectId=${tasks.projectId}&taskId=${tasks.taskId}">修改</a>/
							<a
							href="javascript:if(confirm('确实要删除该任务吗?'))location='${pageContext.request.contextPath}/deleteTask.action?projectId=${tasks.projectId}&taskId=${tasks.taskId}'">删除</a>
						</td>
					</s:if>
				</tr>
			</tbody>
			</tbody>
		</s:iterator>


	</table>
</body>
</html>
