package com.example.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Besoin;
import com.example.web.service.BesoinService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BesoinController {

	@Autowired
	BesoinService besoinService;
	
	@GetMapping("/besoins/index")
	List<Besoin>  indexBesoins()  {
		return besoinService.getAllBesoins();		
	}
	@PostMapping("/besoins/create")
	ResponseEntity  storeBesoin(@RequestBody Besoin newBesoin)  {
		Besoin besoin = besoinService.addBesoin(newBesoin);
		if(besoin != null) {
			
			 return new ResponseEntity(HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	
	@PutMapping("/besoins/edit")
	ResponseEntity editBesoin(@RequestBody Besoin newBesoin)  {
		Besoin besoin = besoinService.updateBesoin(newBesoin);
		
		  if(besoin != null) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}
	@PostMapping("/besoins/show")
	ResponseEntity<Besoin>  showBesoin(@RequestBody Besoin newBesoin)  {
		Besoin besoin = besoinService.getBesoin(newBesoin);
		
		  if(besoin != null) {
			
			 return new ResponseEntity<Besoin>(besoin, HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	}
	
	@PostMapping("/besoins/delete")
	ResponseEntity deleteBesoin(@RequestBody Besoin besoin)  {
		 
		
		  if(besoinService.deleteBesoin(besoin.getId())) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}

}
