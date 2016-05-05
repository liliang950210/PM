package com.pm.service;


import java.util.List;

import com.pm.table.PersonEdition;
public interface PersonEditionService {

	public void savePersonEdition(PersonEdition personEdition);
	public void updatePersonEdition(PersonEdition personEdition);
	public void deletePersonEdition(PersonEdition personEdition);
	public List<PersonEdition> findAllList();
//	public User findUserById(int id);
//	public User findUserByUsernameAndPassword(String username, String password);

}
