package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.BDao;
import com.pm.service.CostService;
import com.pm.table.ProjectCost;
@Service("costService")
public class CostServiceImpl implements CostService{
	@Resource
	private BDao<ProjectCost> bDao ;

	

	@Transactional
	public void updateAll(List<ProjectCost> list) {
		// TODO Auto-generated method stub
		for(ProjectCost cost:list){
			bDao.save(cost);
		}
		
	}

	@Transactional
	public void addCost(ProjectCost project_cost) {
		// TODO Auto-generated method stub
		System.out.print(">>>>>>>>>>"+project_cost.getCostItem()+project_cost.getCostExpense()+project_cost.getCostDescription());;
		bDao.save(project_cost);
	}

	@Transactional
	public void deleteCost(ProjectCost project_cos) {
		// TODO Auto-generated method stub
		bDao.delete(project_cos);
	}

	

	@Transactional
	public void updateOne(ProjectCost project_cost) {
		// TODO Auto-generated method stub
		bDao.saveOrUpdate(project_cost);
	}

	@Transactional
	public List<ProjectCost> findAll(String project_id) {
		// TODO Auto-generated method stub
		return bDao.find("from ProjectCost project_cost where project_cost.projectId = '"+project_id+"'");
	}

	@Transactional
	public List<ProjectCost> findOne(String name, String project_id) {
		// TODO Auto-generated method stub
		return bDao.find("from ProjectCost project_cost where project_cost.projectId='"+
		project_id+"'and project_cost.costItem='"+name+"'");
	}

	@Transactional
	public ProjectCost findById(String project_id, String id) {
		// TODO Auto-generated method stub
		return bDao.find("from ProjectCost project_cost where project_cost.projectId = '"+project_id+"'and project_cost.costId='"+id+"'").get(0);
	}

	

}
