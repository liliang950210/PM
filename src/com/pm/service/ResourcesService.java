package com.pm.service;

import java.util.List;

import com.pm.table.ProjectResource;

public interface ResourcesService {
	public List<ProjectResource> findAll(String project_id ,String type);
	public List<ProjectResource> findOne(String project_id,String type,String name);
	public void add(ProjectResource res);
	public void delete(ProjectResource res);
	public ProjectResource findById(String projectId,String resourceId); 

}
