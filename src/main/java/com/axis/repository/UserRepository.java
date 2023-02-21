package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
	
	public User findByUsernameAndPassword(String username, String password);

}
