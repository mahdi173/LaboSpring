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

import com.example.web.model.Labo;
import com.example.web.service.LaboService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LaboController {

	@Autowired
	LaboService laboService;
	
	@GetMapping("/laboratoires/index")
	List<Labo>  indexLabs()  {
		return laboService.getAllLaboratoires();		
	}
	@PostMapping("/laboratoires/create")
	ResponseEntity  storeLabo(@RequestBody Labo newLabo)  {
		Labo labo = laboService.addLabo(newLabo);
		if(labo != null) {
			
			 return new ResponseEntity(HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	
	@PutMapping("/laboratoires/edit")
	ResponseEntity editLabo(@RequestBody Labo newLabo)  {
		Labo labo = laboService.updateLabo(newLabo);
		
		  if(labo != null) {
			
			 return new ResponseEntity(HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	@PostMapping("/laboratoires/show")
	ResponseEntity<Labo>  showLabo(@RequestBody Labo newLabo)  {
		Labo labo = laboService.getLabo(newLabo);
		
		  if(labo != null) {
			
			 return new ResponseEntity<Labo>(labo, HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	}
	
	@PostMapping("/laboratoires/delete")
	ResponseEntity  deleteLabo(@RequestBody Labo newLabo)  {
		 
		
		  if(laboService.deleteLabo(newLabo.getId())) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity( HttpStatus.BAD_REQUEST);
			}
	}
}
