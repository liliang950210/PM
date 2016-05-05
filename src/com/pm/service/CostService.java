package com.pm.service;

import java.util.List;

import com.pm.table.ProjectCost;


/**
 * @author chuankun
 *上午11:12:34  2015年12月10日
 */
public interface CostService {
	public List<ProjectCost> findAll(String project_id);
	public void updateAll(List<ProjectCost> list);
	public void  updateOne(ProjectCost project_cost);
	public void  addCost( ProjectCost project_cost);
	public void deleteCost(ProjectCost project_cost);
	public List<ProjectCost> findOne( String name,String project_id) ;
	public ProjectCost findById(String project_id,String id );

}
