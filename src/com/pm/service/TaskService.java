package com.pm.service;

import com.pm.table.ProjectTask;
import com.pm.table.User;

import java.util.List;

/**
 * 任务相关的接口
 * @author JiangLongwei
 * @date 2015年12月5日
 */
public interface TaskService {

	/**
	 * 保存task
	 * @param task
	 */
	public void saveTask(ProjectTask task);
	public void deleteTask(ProjectTask task);
	public void updateTask(ProjectTask task);
	/**
	 * 跟userId相关联的task都清除
	 * @param userId
	 */
	public void deleteTasksByUserId(String userId);
	/**
	 * 通过projectId找到相应的任务信息
	 * @param projectId
	 * @return
	 */
	public List<ProjectTask> findTaskListByProjectId(String projectId);
	/**
	 * 通过Id查找user
	 * @param id
	 * @return
	 */
	public ProjectTask findTaskById(int id);
}
