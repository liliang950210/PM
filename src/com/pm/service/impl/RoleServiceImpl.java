package com.pm.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pm.dao.BDao;
import com.pm.service.RoleService;
import com.pm.table.Role;
/**
 * 
 * @author JiangLongwei
 * @date 2015年12月8日
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Resource
	private BDao<Role> bDao;
	
	@Transactional
	public Role findRoleById(int id) {
		return bDao.get(Role.class, id);
	}

}
