package com.example.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Role;
import com.example.web.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	  RoleRepository roleRepository;
	
	public Role getRole(String name) {
	   return roleRepository.getRoleByName(name);	
	}
}
