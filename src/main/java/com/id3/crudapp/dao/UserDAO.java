package com.id3.crudapp.dao;

import java.util.List;

import com.id3.crudapp.entity.User;

public interface UserDAO {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
	
}
