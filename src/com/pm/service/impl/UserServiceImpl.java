package com.pm.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.BDao;
import com.pm.service.UserService;
import com.pm.table.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	/* 根据具体类型做变动，此处为实例化一个User类型的DAO来对数据库操作 */
	@Resource
	private BDao<User> bDao;
	/* 保存对象user */
	@Transactional
	public void saveUser(User user) {
		bDao.save(user);
	}
	/* 更新对象User */
	public void updateUser(User user) {
		bDao.update(user);
	}
	/* 删除对象User */
	public void deleteUser(User user) {
		bDao.delete(user);
	}
	/* 查询表中所有的内容 */
	public List<User> findAllList(){
		/* 执行sql语句 */
		return bDao.find(" from user");
	}
	/* 通过id找到对象User */
	@Transactional
	public User findUserById(int id) {
		/* 根据需要查找的类类型以及id，返回对应id的对象 */
		return bDao.get(User.class, id);
	}
	@Transactional
	/* 匹配用户名和密码 */
	public User findUserByUsernameAndPassword(String username, String password) {
		/* 执行sql语句，将查询参数作为对象放在Object中 */
		return bDao.get(" from User where username=? and password=?", new Object[]{username,password});
	}
	
	/**
	 * 检查是否存在该用户
	 */
	@Transactional
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return bDao.get(" from User where username=?",new Object[]{username});
	}
}
