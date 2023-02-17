package com.axis.service;

import java.util.List;

import com.axis.dto.AdminDto;

public interface AdminService {
	
	AdminDto addNewAdmin(AdminDto adminDto);
	List<AdminDto> getAllAdmin();

}
