package com.pm.bean;


import com.pm.table.User;

/**
 * TaskBean 类，负责页面任务的数据呈现
 * @author JiangLongwei
 * @date 2015年12月7日
 */
public class TaskBean {

	private Integer taskId;
	private String projectId;
//	private String userId;
	private String startTime;
	private String taskPlan;
	private String endTime;
	
	/**
	 * 持续时间，标识为天数小时
	 */
	private String lastedTime;
	
	
	/**
	 * 任务信息中存储有user的信息
	 */
	private User user;
	
	public Integer getTaskId(){
		return this.taskId;
	}
	public void setTaskId(Integer taskId){
		this.taskId=taskId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	
	public String getTaskPlan(){
		return this.taskPlan;
	}
	public void setTaskPlan(String taskPlan){
		this.taskPlan=taskPlan;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLastedTime() {
		return lastedTime;
	}
	public void setLastedTime(String lastedTime) {
		this.lastedTime = lastedTime;
	}
	
	
	
}
