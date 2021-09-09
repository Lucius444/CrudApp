package com.id3.crudapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.id3.crudapp.entity.User;
import com.id3.crudapp.service.UserService;


@RestController
public class UserRestController {
	
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/get-all-users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/get-user-by-id/{userId}")
	public User findById(@PathVariable int userId) {
		User theUser = userService.findById(userId);
		
		if(theUser==null) {
			throw new RuntimeException ("Requested user not found - id = " + userId);
		}
		return theUser;
	}
	
	@PutMapping("/update-user")
	public User updateUser(@RequestBody User theUser) {	
		userService.save(theUser);
		return theUser;
	}
	
	
	@PostMapping("/create-user")
	public User createUser(@RequestBody User theUser) {
		theUser.setId(0);
		userService.save(theUser);	
		return theUser;
	}
	
	@DeleteMapping("/delete-user-by-id/{userId}")
	public String deleteUser(@PathVariable int userId) {
		User tempUser = userService.findById(userId);
		
		if(tempUser==null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted user id - " + userId;
	}
	
	
	
}
