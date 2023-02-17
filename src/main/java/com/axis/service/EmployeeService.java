package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.axis.dto.EmployeeDto;
import com.axis.repository.EmployeeRepository;

public interface EmployeeService {
	
	
	
	EmployeeDto addNewEmployee(EmployeeDto employeeDto);
	List<EmployeeDto> getAllEmployee();
	
//	public void deleteEmployeeById(int id) {
	 //     EmployeeRepository.deleteById(id);
	 //  }
}
