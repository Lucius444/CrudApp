package com.id3.crudapp.service;

import java.io.IOException;
import java.util.List;

import com.id3.crudapp.dao.IPlantDAO;
import com.id3.crudapp.dto.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id3.crudapp.dao.UserDAO;
import com.id3.crudapp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	@Autowired
	private IPlantDAO plantDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO theUserDAO) {
		userDAO=theUserDAO;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {	
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User findById(int theId) {		
		return userDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(User theUser) {
		userDAO.save(theUser);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		userDAO.deleteById(theId);
	}

	@Override
	public List<Plant> fetchPlants(String combinedName) throws IOException {
		return plantDAO.fetchPlants(combinedName);
	}

}
