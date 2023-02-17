package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.EmployeeDto;
import com.axis.entity.Employee;
import com.axis.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto addNewEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		return convertToDto(employeeRepository.save(convertToEntity(employeeDto)));
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private EmployeeDto convertToDto(Employee employee) {
		EmployeeDto employeeDto=new EmployeeDto();
		
		employeeDto.setEmpID(employee.getEmpID());
		employeeDto.setEmpCompanyName(employee.getEmpCompanyName());
		employeeDto.setEmpAddress(employee.getEmpAddress());
		employeeDto.setEmpDepartment(employee.getEmpDepartment());
		employeeDto.setEmpEmail(employee.getEmpEmail());
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmpPhno(employee.getEmpPhno());
		employeeDto.setEmpPosition(employee.getEmpPosition());
		employeeDto.setEmpSalary(employee.getEmpSalary());
		
		return employeeDto;
		
	}
	private Employee convertToEntity(EmployeeDto employeeDto) {
		Employee employee=new Employee();
		
		employee.setEmpID(employeeDto.getEmpID());
		employee.setEmpCompanyName(employeeDto.getEmpCompanyName());
		employee.setEmpAddress(employeeDto.getEmpAddress());
		employee.setEmpDepartment(employeeDto.getEmpDepartment());
		employee.setEmpEmail(employeeDto.getEmpEmail());
		employee.setEmpName(employeeDto.getEmpName());
		employee.setEmpPhno(employeeDto.getEmpPhno());
		employee.setEmpPosition(employeeDto.getEmpPosition());
		employee.setEmpSalary(employeeDto.getEmpSalary());
		
		return employee;
		
	}
	
	public List<Employee> getAllEmp() {
		return employeeRepository.findAll();
	}

	public Employee getEMpById(int id) {
		Optional<Employee> e = employeeRepository.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEMp(int id) {
		employeeRepository.deleteById(id);
	}

	

}
