package com.pm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.TaskBean;
import com.pm.service.RelationService;
import com.pm.service.TaskService;
import com.pm.service.UserService;
import com.pm.table.ProjectTask;
import com.pm.table.User;
import com.pm.utils.DateUtils;

/**
 * 添加或修改确认类
 * 
 * @author JiangLongwei
 * @date 2015年12月7日
 */
@Controller
public class TaskAddConfirmAction extends ActionSupport {

	private String projectId;
	private int roleId;
	private TaskBean taskBean;
	@Resource
	private TaskService taskService;

	@Resource
	private UserService userService;

	private List<TaskBean> taskBeans;

	/**
	 * 执行修改task内容，不存在则进行添加
	 * 
	 * @return
	 */
	public String changeTask() {



		ProjectTask saveTask = new ProjectTask();
		
		saveTask.setProjectId(taskBean.getProjectId());
		saveTask.setTaskPlan(taskBean.getTaskPlan());
		saveTask.setUserId(String.valueOf(taskBean.getUser().getId()));
		saveTask.setStartTime(new Date(DateUtils.getMsByDate(taskBean.getStartTime())));
		saveTask.setEndTime(new Date(DateUtils.getMsByDate(taskBean.getEndTime())));
		
		 // 执行添加或修改指令
		if (taskBean.getTaskId() == null || taskBean.getTaskId().equals("")) {
			
			taskService.saveTask(saveTask);
			
		} else {
			saveTask.setTaskId(taskBean.getTaskId());
			taskService.updateTask(saveTask);
		}

		
		
		// 更新相应的数据
		List<ProjectTask> tasks = taskService
				.findTaskListByProjectId(taskBean.getProjectId());
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
		setProjectId(taskBean.getProjectId());
		setRoleId(1);
		return SUCCESS;

	}

	public TaskBean getTaskBean() {
		return taskBean;
	}

	public void setTaskBean(TaskBean taskBean) {
		this.taskBean = taskBean;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<TaskBean> getTaskBeans() {
		return taskBeans;
	}

	public void setTaskBeans(List<TaskBean> taskBeans) {
		this.taskBeans = taskBeans;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
