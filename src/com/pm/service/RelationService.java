package com.pm.service;

import java.util.List;

import com.pm.table.IdRelation;

/**
 * 关系表的接口
 * @author JiangLongwei
 * @date 2015年12月8日
 */
public interface RelationService {

	/**
	 * 通过projectId查询所有关联的表格
	 * @param projectId
	 * @return
	 */
	public List<IdRelation> findRelationsByProjectId(String projectId);
	
	public void deleteRelation(IdRelation relation);
	
	public void saveRelation(IdRelation relation);
}
