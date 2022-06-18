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
import com.example.web.model.Responsable;
import com.example.web.model.Role;
import com.example.web.service.AdminService;
import com.example.web.service.RespoService;
import com.example.web.service.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RespoController {

	@Autowired
	RespoService respoService;
	
	@Autowired
    RoleService roleService;
	
	@GetMapping("/respos/index")
	List<Responsable>  index()  {
		return respoService.getAllRespos();		
	}
	
	@PostMapping("/respos/create")
	ResponseEntity  store(@RequestBody Responsable responsable)  {
		Role role= roleService.getRole("responsable");
		responsable.getRoles().add(role);
		Responsable r = respoService.save(responsable);
		if(r != null) {
			
			 return new ResponseEntity(HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	@PutMapping("/respos/edit")
	ResponseEntity edit(@RequestBody Responsable responsable)  {
		Responsable r = respoService.update(responsable);
		
		  if(r != null) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}

	
	@PostMapping("/respos/delete")
	ResponseEntity delete(@RequestBody Responsable responsable)  {
		 
		
		  if(respoService.delete(responsable.getId())) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}

}
