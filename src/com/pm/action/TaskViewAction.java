package com.pm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

//import org.apache.tomcat.util.threads.TaskThread;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.TaskBean;
import com.pm.service.ScopeService;
import com.pm.service.TaskService;
import com.pm.service.UserService;
import com.pm.table.ProjectTask;
import com.pm.table.User;
import com.pm.utils.DateUtils;

import freemarker.template.utility.DateUtil;

/**
 * 查看任务安排
 * @author JiangLongwei
 * @date 2015年12月5日
 */

@Controller
public class TaskViewAction extends ActionSupport {

	@Resource
	private TaskService taskService;

	@Resource
	private UserService userService;

	private List<TaskBean> taskBeans;
	
	private String projectId;
	private int roleId;
	
	public String viewTask() {

		List<ProjectTask> tasks = taskService.findTaskListByProjectId(getProjectId());

		
		List<TaskBean> taskBeans = new ArrayList<TaskBean>();
		int size = tasks.size();
		for(int i=0 ;i<size;i++){
			TaskBean taskBean = new TaskBean();
			taskBean.setTaskId(tasks.get(i).getTaskId());
			taskBean.setTaskPlan(tasks.get(i).getTaskPlan());
			taskBean.setProjectId(tasks.get(i).getProjectId());
			taskBean.setStartTime(DateUtils.date2str(tasks.get(i).getStartTime(), false));
			taskBean.setEndTime(DateUtils.date2str(tasks.get(i).getEndTime(), false));
			taskBean.setLastedTime(DateUtils.getLastedTime(tasks.get(i).getEndTime(),tasks.get(i).getStartTime()));
//			taskBean.setUser(tasks.get(i).getUser());
			taskBean.setUser(userService.findUserById(Integer.valueOf(tasks.get(i).getUserId())));
			taskBeans.add(taskBean);
		}
		
		setTaskBeans(taskBeans);

		
		//这里要set进去必要的Id
		setProjectId(getProjectId());
		setRoleId(getRoleId());
		return SUCCESS;
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
