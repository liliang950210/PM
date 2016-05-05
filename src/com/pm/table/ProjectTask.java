package com.pm.table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project_task")
public class ProjectTask {

	private Integer taskId;
	private String projectId;
	private String userId;
	private Date startTime;
	private String taskPlan;
	private Date endTime;
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="task_id",length=4)
	public Integer getTaskId(){
		return this.taskId;
	}
	public void setTaskId(Integer taskId){
		this.taskId=taskId;
	}
	@Column(name="project_id",length=4)
	public String getProjectId(){
		return this.projectId;
	}
	public void setProjectId(String projectId){
		this.projectId=projectId;
	}
	@Column(name="user_id",length=4)
	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	@Column(name="task_plan",length=65536)
	public String getTaskPlan(){
		return this.taskPlan;
	}
	public void setTaskPlan(String taskPlan){
		this.taskPlan=taskPlan;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	public Date getStartTime(){
		return this.startTime;
	}
	public void setStartTime(Date startTime){
		this.startTime=startTime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_time")
	public Date getEndTime(){
		return this.endTime;
	}
	public void setEndTime(Date endTime){
		this.endTime=endTime;
	}
	/**
	 *  获取user的值
	 * @author JiangLongwei
	 * @return
	 */
//	private User user;
//	@OneToOne
//	@JoinColumn(name="user_id")
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
}
