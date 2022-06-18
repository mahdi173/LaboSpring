package com.example.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.web.model.Admin;
import com.example.web.repository.AdminRepository;

@Service
public class AdminService {

	
	@Autowired
	 AdminRepository adminRepo;
	@Autowired
	private PasswordEncoder passwordEncoder; 
	 public Admin save (Admin a) {
		 a.setPassword(passwordEncoder.encode(a.getPassword()));

			return adminRepo.save(a);
			
		} 
	    public Admin update(Admin a) {
			
			return adminRepo.save(a);
			
		} 
	   
	    
	    public boolean delete(final Long id) {
	    	try {
	    		adminRepo.deleteById(id);
			return true;
	    	}catch(Exception e) {
	    		return false;
	    		
	    	}
	    }
}
