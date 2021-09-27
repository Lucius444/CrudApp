package com.id3.crudapp.service;

import java.io.IOException;
import java.util.List;

import com.id3.crudapp.dto.Plant;
import com.id3.crudapp.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);

	List<Plant> fetchPlants(String combinedName) throws IOException;
	
}
