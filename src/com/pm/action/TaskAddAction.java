package com.pm.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.From;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pm.bean.TaskBean;
import com.pm.bean.UserBean;
import com.pm.service.RelationService;
import com.pm.service.TaskService;
import com.pm.service.UserService;
import com.pm.table.IdRelation;
import com.pm.table.ProjectTask;
import com.pm.table.User;
import com.pm.utils.DateUtils;

import freemarker.template.utility.DateUtil;

/**
 * 跳转至task修改或添加的界面的Action
 * 
 * @author JiangLongwei
 * @date 2015年12月7日
 */

@Controller
public class TaskAddAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource
	private TaskService taskService;

	@Resource
	private RelationService relationService;

	@Resource
	private UserService userService;

	private String taskId;
	private String projectId;
	// private ProjectTask projectTask;
	private TaskBean taskBean;

	private List<UserBean> userBeans;

	// private String startTime;
	// private String endTime;

	/**
	 * 检索是否存在taskId，并传递到taskAdd呈现页面
	 * 
	 * @return
	 */
	public String addTask() {

		System.out.println("获取到的taskId为" + taskId);
		System.out.println("获取到的projectId为" + projectId);

		List<IdRelation> relations = relationService
				.findRelationsByProjectId(projectId);
		int size = relations.size();

		List<UserBean> users = new ArrayList<UserBean>();

		// 查询到跟项目相关的userId

		for (int i = 0; i < size; i++) {

			//TODO 写死参数，只是为忽略产品经理，这种作法欠妥
//			if(relations.get(i).getRoleId().equals("1")){
//				continue;
//			}
			
			User user = userService.findUserById(Integer.parseInt(relations
					.get(i).getUserId()));

			if(user==null){
				continue;
			}
				
			// 负责人可以为空 不允许出现其他情况
//			if (user == null) {
//				UserBean userBean = new UserBean();
//				userBean.setId(0);
//				userBean.setUsername("无");
//				userBean.setIsSelected(0);
//				users.add(userBean);
//				continue;
//			}
			UserBean userBean = new UserBean();
			userBean.setId(user.getId());
			userBean.setUsername(user.getUsername());
			userBean.setIsSelected(0);
			users.add(userBean);
		}

		TaskBean taskFormBean = new TaskBean();
		if (taskId != null && !taskId.equals("")) {
			// 存在taskId的时候
			ProjectTask task = taskService.findTaskById(Integer
					.parseInt(taskId));

			taskFormBean.setTaskPlan(task.getTaskPlan());
			taskFormBean.setTaskId(task.getTaskId());
			taskFormBean.setProjectId(projectId);
			taskFormBean.setStartTime(DateUtils.date2str(task.getStartTime(),
					true));
			taskFormBean
					.setEndTime(DateUtils.date2str(task.getEndTime(), true));
			taskFormBean.setUser(userService.findUserById(Integer.valueOf(task.getUserId())));

			// 遍历下拉选择框的数据，设置默认值 将任务对应的user selected了

			int usersSize = users.size();
			for (int i = 0; i < usersSize; i++) {
				if(userService.findUserById(Integer.valueOf(task.getUserId())).getId()==users.get(i).getId()){
					users.get(i).setIsSelected(1);
					break;
				}
			}

			setTaskBean(taskFormBean);
		} else {

			taskFormBean.setProjectId(projectId);

			taskFormBean.setStartTime(DateUtils.getCurCalendar(true));
			taskFormBean.setEndTime(DateUtils.getCurCalendar(true));
			setTaskBean(taskFormBean);
		}

		setTaskId(taskId);
		setUserBeans(users);
		return SUCCESS;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public TaskBean getTaskBean() {
		return taskBean;
	}

	public void setTaskBean(TaskBean taskBean) {
		this.taskBean = taskBean;
	}

	public List<UserBean> getUserBeans() {
		return userBeans;
	}

	public void setUserBeans(List<UserBean> userBeans) {
		this.userBeans = userBeans;
	}

}
