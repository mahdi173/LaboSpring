package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Admin;
import com.example.web.model.Besoin;
import com.example.web.model.Role;
import com.example.web.service.AdminService;
import com.example.web.service.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
    RoleService roleService;
	
	@PostMapping("/admins/create")
	ResponseEntity  store(@RequestBody Admin admin)  {
		Role role= roleService.getRole("admin");
		admin.getRoles().add(role);
		Admin a = adminService.save(admin);
		if(a != null) {
			
			 return new ResponseEntity(HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	@PutMapping("/admins/edit")
	ResponseEntity edit(@RequestBody Admin admin)  {
		Admin a = adminService.update(admin);
		
		  if(a != null) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}

	
	@PostMapping("/admins/delete")
	ResponseEntity delete(@RequestBody Admin admin)  {
		 
		
		  if(adminService.delete(admin.getId())) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}


}
