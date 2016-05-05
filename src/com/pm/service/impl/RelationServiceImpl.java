package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.omg.PortableServer.POA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.BDao;
import com.pm.service.RelationService;
import com.pm.table.IdRelation;

@Service("relationService")
public class RelationServiceImpl implements RelationService{

	@Resource
	private BDao<IdRelation> bDao;
	
	@Transactional
	public List<IdRelation> findRelationsByProjectId(String projectId) {
		// TODO Auto-generated method stub
		return bDao.find("from IdRelation where projectId=?",new Object[]{projectId});
	}

	@Transactional
	public void saveRelation(IdRelation relation) {
		// TODO Auto-generated method stub
		
		bDao.save(relation);
	}

	@Transactional
	public void deleteRelation(IdRelation relation) {
		// TODO Auto-generated method stub
		
		bDao.delete(relation);
	}

	
	
	
}
