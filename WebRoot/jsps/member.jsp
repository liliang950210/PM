<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function isVerify(form) {
		with (form) {
			if (formUsername.value == "") {
				alert("请输入项目成员的username");
				return false;
			}
		}
		return true;
	}
</script>

</head>

<body>
	<br>
	<h1>项目成员管理:</h1>
	<br />
	<table border="1">
		<tbody>
			<tr>
				<th>姓名</th>
				<th>职责</th>
				<s:if test="roleId==1">
					<th>操作</th>
				</s:if>
			</tr>
		</tbody>

		<s:iterator value="userBeans" var="users">
			<tbody>
				<tr>
					<th><s:property value="#users.username" /></th>
					<th><s:property value="#users.role" /></th>
					<s:if test="1==#users.isChange">
						<td>
						
						<a
							href="javascript:if(confirm('确实要删除该任务吗?'))location='${pageContext.request.contextPath}/deleteMember.action?projectId=${request.projectId}&userId=${users.id}'">删除</a>
						</td>
					</s:if>
				</tr>
			</tbody>
		</s:iterator>
		<s:if test="isAdd==1">
			<form action="${pageContext.request.contextPath}/addMember.action"
				method="post" onsubmit="return isVerify(this)">
				<tr>
					<td><input type="text" name="userName" id="formUsername" /></td>
					<th>项目成员</th>
					<td>
						<!-- 这里默认为2,即为项目成员 --> <input type="hidden" value="2"
						name="memberRoleId" /> <input type="hidden" value="${projectId}"
						name="projectId" /> <input type="submit" value="确认添加" />
					</td>
				</tr>
			</form>
		</s:if>
	</table>
	<br />
	<s:if test="isAdd!=1&&roleId==1">
		<a href="${pageContext.request.contextPath}/viewMember.action?projectId=${projectId}&isAdd=1&roleId=1">添加成员</a>
	</s:if>

	<h2>${errorMsg}</h2>

</body>
</html>
