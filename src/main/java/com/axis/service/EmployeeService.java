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
	List<EmployeeDto> getAllEmployee();
	
	//public List<Employee> getAllEmp() {
	//	return employeeRepository.findAll();
	//}

	public default Employee getEMpById(int id) {
		Optional<Employee> e = employeeRepository.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public default void deleteEMp(int id) {
		employeeRepository.deleteById(id);
	}
}
