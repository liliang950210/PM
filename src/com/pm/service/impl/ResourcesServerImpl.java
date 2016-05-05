package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.BDao;
import com.pm.service.ResourcesService;
import com.pm.table.ProjectResource;
@Service("resorceService")
public class ResourcesServerImpl implements ResourcesService{
	@Resource
	private BDao<ProjectResource> bDao ;
	
	@Transactional
	public List<ProjectResource> findAll(String project_id, String type) {
		// TODO Auto-generated method stub
		return bDao.find("from ProjectResource res where res.projectId='"
				+ project_id+"'and res.resourceType='"+type+"'");
	}

	@Transactional
	public List<ProjectResource> findOne(String project_id, String type,
			String name) {
		// TODO Auto-generated method stub
		return bDao.find( " from ProjectResource res where res.projectId='"
				+ project_id+"' and res.resourceType='"+type+"'and res.resourceName='"+name+"'");
	}

	@Transactional
	public void add(ProjectResource res) {
		// TODO Auto-generated method stub
		bDao.saveOrUpdate(res);
		
	}

	@Transactional
	public void delete(ProjectResource res) {
		// TODO Auto-generated method stub
		bDao.delete(res);
	}

	@Transactional
	public ProjectResource findById(String projectId, String resourceId) {
		// TODO Auto-generated method stub
		return bDao.find("from ProjectResource where projectId='"+projectId+"'and resourceId='"+resourceId+"'").get(0);
	}

}
