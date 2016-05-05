package com.pm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.BDao;
import com.pm.service.PersonEditionService;
import com.pm.table.PersonEdition;

@Service("personEditionService")
public class PersonEditionServiceImpl implements PersonEditionService{
	/* 鏍规嵁鍏蜂綋绫诲瀷鍋氬彉鍔紝姝ゅ涓哄疄渚嬪寲涓�釜User绫诲瀷鐨凞AO鏉ュ鏁版嵁搴撴搷浣�*/
	@Resource
	private BDao<PersonEdition> bDao;
	/* 淇濆瓨瀵硅薄user */
	@Transactional
	public void savePersonEdition(PersonEdition personEdition) {
		bDao.save(personEdition);
	}
	/* 鏇存柊瀵硅薄User */
	public void updatePersonEdition(PersonEdition personEdition) {
		bDao.update(personEdition);
	}
	
	/* 鍒犻櫎瀵硅薄User */
	public void deletePersonEdition(PersonEdition personEdition) {
		bDao.delete(personEdition);
	}
	@Transactional
	public List<PersonEdition> findAllList(){
		
		return bDao.find(" from PersonEdition");
	}
/*	
	public User findUserById(int id) {
		
		return bDao.get(User.class, id);
	}
	

	@Transactional
	
	public User findUserByUsernameAndPassword(String username, String password) {
		
		return bDao.get(" from User where username=? and password=?", new Object[]{username,password});
	}
*/	
}

