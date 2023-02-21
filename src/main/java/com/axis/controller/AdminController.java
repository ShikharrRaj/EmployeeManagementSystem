package com.axis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.AdminDto;
import com.axis.dto.EmployeeDto;
import com.axis.entity.Admin;
import com.axis.entity.Employee;
import com.axis.service.AdminService;
import com.axis.service.EmployeeService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<AdminDto>addAdmin(@RequestBody AdminDto admindto){
		return new ResponseEntity<AdminDto>(adminService.addNewAdmin(admindto), HttpStatus.OK);
	}
	
	@GetMapping("/Adminlist")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmin(), HttpStatus.OK);
	}
	
	@GetMapping("/Admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int id){
		return new ResponseEntity<Admin>(adminService.getAdminById(id), HttpStatus.OK);
	}
	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin>updateEmployeeById(@PathVariable int id, @RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.updateAdminById(id, admin), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteadmin/{id}")
	public void deleteAdmin(@PathVariable("id") int id) {
	   adminService.deleteAdmin(id);
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<EmployeeDto>addEmployee(@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<EmployeeDto>(employeeService.addNewEmployee(employeeDto), HttpStatus.OK);
	}
	
	@GetMapping("/emplist")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Employee>updateEmployeeById(@PathVariable int id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(id, employee), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
	   employeeService.deleteEMp(id);
	}


}
