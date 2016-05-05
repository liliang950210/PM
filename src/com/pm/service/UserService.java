package com.pm.service;

import java.util.List;

import com.pm.table.User;

public interface UserService {

	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public List<User> findAllList();
	public User findUserById(int id);
	public User findUserByUsernameAndPassword(String username, String password);

	/**
	 * 通过userName去查询用户存不存在
	 * @param username
	 * @return
	 */
	public User findUserByName(String username);
	
}
