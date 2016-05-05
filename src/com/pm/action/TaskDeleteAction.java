package com.pm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.TaskBean;
import com.pm.service.TaskService;
import com.pm.service.UserService;
import com.pm.table.ProjectTask;
import com.pm.utils.DateUtils;

/**
 * 任务删除的action
 * 
 * @author JiangLongwei
 * @date 2015年12月8日
 */
@Controller
public class TaskDeleteAction extends ActionSupport {

	private List<TaskBean> taskBeans;
	private String projectId;
	private int roleId;
	private String taskId;
	@Resource
	private TaskService taskService;

	@Resource
	private UserService userService;
	public String deleteTask() {

		System.out.println("--准备执行删除任务--");

		ProjectTask task = new ProjectTask();
		task.setTaskId(Integer.parseInt(getTaskId()));
		taskService.deleteTask(task);

		// 更新相应的数据
		List<ProjectTask> tasks = taskService
				.findTaskListByProjectId(getProjectId());
		List<TaskBean> taskBeans = new ArrayList<TaskBean>();
		int size = tasks.size();
		for (int i = 0; i < size; i++) {
			TaskBean taskBean = new TaskBean();
			taskBean.setTaskId(tasks.get(i).getTaskId());
			taskBean.setTaskPlan(tasks.get(i).getTaskPlan());
			taskBean.setProjectId(tasks.get(i).getProjectId());
			taskBean.setStartTime(DateUtils.date2str(tasks.get(i)
					.getStartTime(), false));
			taskBean.setEndTime(DateUtils.date2str(tasks.get(i).getEndTime(),
					false));
			taskBean.setLastedTime(DateUtils.getLastedTime(tasks.get(i).getEndTime(),tasks.get(i).getStartTime()));
			taskBean.setUser(userService.findUserById(Integer.valueOf(tasks.get(i).getUserId())));
			taskBeans.add(taskBean);
		}

		setTaskBeans(taskBeans);
		setRoleId(1);
		return SUCCESS;
	}

	public List<TaskBean> getTaskBeans() {
		return taskBeans;
	}

	public void setTaskBeans(List<TaskBean> taskBeans) {
		this.taskBeans = taskBeans;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
