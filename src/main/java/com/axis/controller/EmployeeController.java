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

import com.axis.dto.EmployeeDto;
import com.axis.entity.Employee;
import com.axis.service.EmployeeService;



@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmp")
	public ResponseEntity<EmployeeDto>addEmployee(@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<EmployeeDto>(employeeService.addNewEmployee(employeeDto), HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		employeeService.addNewEmployee(employeeDto);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		return "redirect:/";
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
	   employeeService.deleteEmployeeById(id);
	}

}
