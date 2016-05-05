<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function isVerify(form) {
		with (form) {
			if (formTaskPlan.value == "") {
				alert("请填写任务计划");
				return false;
			}
			if (formStartTime.value == "") {
				alert("请填写任务开始执行时间");
				return false;
			}
			if (formEndTime.value == "") {
				alert("请填写任务预期结束时间");
				return false;
			}
		}
		return true;
	}
</script>
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
	<h1>添加任务计划界面</h1>
	<br>
	<form action="${pageContext.request.contextPath}/changeTask.action"
		method="post" onsubmit="return isVerify(this)">

		任务计划<input type="text" name="taskBean.taskPlan" id="formTaskPlan"
			value="${taskBean.taskPlan}" /> <br /> 开始时间<input
			type="datetime-local" name="taskBean.startTime" id="formStartTime"
			value="${taskBean.startTime}" /> <br /> 结束时间<input
			type="datetime-local" name="taskBean.endTime" id="formEndTime"
			value="${taskBean.endTime}" /> <br /> 负责人 <select
			name="taskBean.user.id">
			<s:iterator value="userBeans" id="users">

				<option value="${users.id}"
					<s:if test="#users.isSelected==1">
				selected="selected"
				</s:if>>
					<s:property value="username" />
				</option>


			</s:iterator>


		</select> <br /> <input type="hidden" name="taskBean.projectId"
			value="${taskBean.projectId}" /> <input type="hidden"
			name="taskBean.taskId" value="${taskBean.taskId}" /> <input
			type="submit"
			<s:if test="taskId==''">
			 value="确认添加"
			</s:if>
			<s:else>
			value="确认修改"
			</s:else> />


	</form>

</body>
</html>
