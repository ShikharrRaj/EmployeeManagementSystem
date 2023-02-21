package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.axis.dto.EmployeeDto;
import com.axis.entity.Employee;
import com.axis.repository.EmployeeRepository;

public interface EmployeeService {
	
	public static final EmployeeRepository employeeRepository = null;
	
	EmployeeDto addNewEmployee(EmployeeDto employeeDto);
	
	List<Employee> getAllEmployee();
	
	
	Employee updateEmployeeById(int id, Employee employee);

	Employee getEmployeeById(int id);

	public default void deleteEMp(int id) {
		employeeRepository.deleteById(id);
	}
}
