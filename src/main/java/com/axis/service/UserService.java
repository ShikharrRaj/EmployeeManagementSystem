package com.axis.service;

import java.util.List;

import com.axis.entity.User;

public interface UserService {
	
	 User findByUsername(String username);
	
	 User findByUsernameAndPassword(String username, String password);
	
	 User updateUserById(int id, User user);
	
	 User addUser(User user);
	
	 List<User> getAllUsers();
	
	 String deleteUser(int id);

}
