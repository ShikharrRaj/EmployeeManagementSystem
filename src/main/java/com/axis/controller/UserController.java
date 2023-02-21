package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.User;
import com.axis.service.UserService;

@RestController
@RequestMapping("/api/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/signin/{username}")
	public ResponseEntity<User> signin(@PathVariable String username){
		User user=userService.findByUsername(username);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	@GetMapping("/signin")
	public ResponseEntity<List<User>> signin1(){
		List<User> user=userService.getAllUsers();
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody User user){
		User userDetails=userService.addUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User>updateUserById(@PathVariable int id, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUserById(id, user), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteUser(@PathVariable int id) {
		 return new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.OK);
	 }
	
}


