package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.axis.dto.AdminDto;
import com.axis.dto.EmployeeDto;
import com.axis.entity.Admin;
import com.axis.entity.Employee;
import com.axis.repository.AdminRepository;
import com.axis.repository.EmployeeRepository;

public interface AdminService {
	
	public static final AdminRepository adminRepository = null;
	
	public static final EmployeeRepository employeeRepository = null;
	
	AdminDto addNewAdmin(AdminDto adminDto);
	
	List<Admin> getAllAdmin();
	
	Admin updateAdminById(int id, Admin admin);
	
	Admin getAdminById(int id);

	public default void deleteAdmin(int id) {
		adminRepository.deleteById(id);
	}
	
EmployeeDto addNewEmployee(EmployeeDto employeeDto);
	
	List<Employee> getAllEmployee();
	
	
	Employee updateEmployeeById(int id, Employee employee);

	Employee getEmployeeById(int id);

	public default void deleteEMp(int id) {
		employeeRepository.deleteById(id);
	}

}
