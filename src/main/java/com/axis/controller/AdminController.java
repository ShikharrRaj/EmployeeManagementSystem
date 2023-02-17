package com.axis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.AdminDto;
import com.axis.dto.EmployeeDto;
import com.axis.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<AdminDto>addAdmin(@RequestBody AdminDto admindto){
		return new ResponseEntity<AdminDto>(adminService.addNewAdmin(admindto), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public String adminRegister(@ModelAttribute AdminDto adminDto, HttpSession session) {
		adminService.addNewAdmin(adminDto);
		session.setAttribute("msg", "Admin Added Sucessfully..");
		return "redirect:/";
	}
	
	@DeleteMapping("/deleteadmin/{id}")
	public void deleteAdmin(@PathVariable("id") int id) {
	   adminService.deleteAdmin(id);
	}


}
