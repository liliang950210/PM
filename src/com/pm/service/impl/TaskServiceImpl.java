package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.BDao;
import com.pm.service.TaskService;
import com.pm.table.ProjectTask;
import com.pm.table.User;

/**
 * 任务业务实现类
 * 
 * @author JiangLongwei
 * @date 2015年12月6日
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Resource
	private BDao<ProjectTask> bDao;

	@Transactional
	public List<ProjectTask> findTaskListByProjectId(String projectId) {
		// TODO Auto-generated method stub

		return bDao.find("from ProjectTask where projectId=? order by startTime",
				new Object[] { projectId });
	}
	@Transactional
	public ProjectTask findTaskById(int id) {
		return bDao.get(ProjectTask.class, id);
	}
	@Transactional
	public void saveTask(ProjectTask task) {
		bDao.save(task);
	}
	@Transactional
	public void updateTask(ProjectTask task) {
		// TODO Auto-generated method stub
		
		bDao.update(task);
		
	}
	@Transactional
	public void deleteTask(ProjectTask task) {
		// TODO Auto-generated method stub
		bDao.delete(task);
	}
	@Transactional
	public void deleteTasksByUserId(String userId) {
		// TODO Auto-generated method stub
		bDao.executeSql("delete from ProjectTask where userId="+userId);
	}

}
