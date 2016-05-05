package com.pm.service;

import com.pm.table.ProjectScope;

/*
 * 范围服务 
 */
public interface ScopeService {

	public ProjectScope findScopeByProjectId(String projectId);
	
	public void updateProjectScope(ProjectScope projectScope);
	
}
