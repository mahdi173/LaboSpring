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

import com.example.web.model.Membre;
import com.example.web.model.Role;
import com.example.web.service.LaboService;
import com.example.web.service.MembreService;
import com.example.web.service.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MembreController {
	
	@Autowired
     MembreService membreService;
	
	@Autowired
    LaboService laboService;
	
	@Autowired
    RoleService roleService;
	
	@GetMapping("/membres/index")
	List<Membre>  index()  {
		return membreService.getAllMembres();		
	}
	@PostMapping("/membres/create")
	public ResponseEntity  store(@RequestBody Membre newMembre)  {
		//Labo l= laboService.getLabo(null)
		Role r= roleService.getRole("membre");
		newMembre.getRoles().add(r);
		Membre membre = membreService.addMembre(newMembre);
		if(membre != null) {
			
			 return new ResponseEntity(HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	
	@PutMapping("/membres/edit")
	public ResponseEntity  edit(@RequestBody Membre newMembre)  {
		Membre membre = membreService.updateMembre(newMembre);
		
		  if(membre != null) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	@PostMapping("/membres/show")
	public ResponseEntity<Membre>  show(@RequestBody Membre newMembre)  {
		Membre membre = membreService.getMembre(newMembre);
		
		  if(membre != null) {
			
			 return new ResponseEntity<Membre>(membre, HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	}
	
	@PostMapping("/membres/delete")
	public ResponseEntity delete(@RequestBody Membre m)  {
		 
		
		  if(membreService.deleteMembre(m)) {
			
			 return new ResponseEntity<>(HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
			}
	}
}
