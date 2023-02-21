package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Employee;
import com.axis.entity.User;
import com.axis.exception.IdNotFoundException;
import com.axis.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsernameAndPassword(username, password);
		return user;
	}

	@Override
	public User updateUserById(int id, User user) {
		// TODO Auto-generated method stub
		Optional<User> u=userRepository.findById(id);
		if(u.isPresent()) {
			return userRepository.save(user);
		}else {
			throw new IdNotFoundException("No Id is present to update");
		}
	}

	

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=userRepository.findAll();
		return users;
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(id).orElseThrow();
		userRepository.delete(user);
		return "deleted successfully" ;
	}

}
