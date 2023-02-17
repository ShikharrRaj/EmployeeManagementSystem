package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.AdminDto;
import com.axis.entity.Admin;
import com.axis.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public AdminDto addNewAdmin(AdminDto adminDto) {
		// TODO Auto-generated method stub
		return convertToDto(adminRepository.save(convertToEntity(adminDto)));
	}

	@Override
	public List<AdminDto> getAllAdmin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private AdminDto convertToDto(Admin admin) {
		AdminDto adminDto=new AdminDto();
		
		adminDto.setAdminId(admin.getAdminId());
		adminDto.setAdminName(admin.getAdminName());
		adminDto.setAdminEmail(admin.getAdminEmail());
		adminDto.setAdminCompanyName(admin.getAdminCompanyName());
		return adminDto;
		
	}
	private Admin convertToEntity(AdminDto adminDto) {
		Admin admin=new Admin();
		
		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminEmail(adminDto.getAdminEmail());
		admin.setAdminCompanyName(adminDto.getAdminCompanyName());
		return admin;
		
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		
	}

}
