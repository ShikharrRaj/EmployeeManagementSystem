package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.axis.dto.AdminDto;
import com.axis.entity.Admin;
import com.axis.entity.Employee;
import com.axis.repository.AdminRepository;

public interface AdminService {
	
	public static final AdminRepository adminRepository = null;
	
	AdminDto addNewAdmin(AdminDto adminDto);
	List<AdminDto> getAllAdmin();
	
	//void deleteAdmin(int id);
	
	public default Admin getAdminById(int id) {
		Optional<Admin> a = adminRepository.findById(id);
		if (a.isPresent()) {
			return a.get();
		}
		return null;
	}

	public default void deleteAdmin(int id) {
		adminRepository.deleteById(id);
	}

}
