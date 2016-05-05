package com.pm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.BDao;
import com.pm.service.ScopeService;
import com.pm.table.ProjectScope;

@Service("scopeService")
public class ScopeServiceImpl implements ScopeService{
	
	
	@Resource
	private BDao<ProjectScope> bDao;
	
	
	@Transactional
	public ProjectScope findScopeByProjectId(String projectId) {
	
		return bDao.get("from ProjectScope where projectId = ?",new Object[]{projectId});
	}


	@Transactional
	public void updateProjectScope(ProjectScope projectScope) {
		bDao.update(projectScope);
	}
	

}
