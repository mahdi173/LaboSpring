package com.example.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Besoin;
import com.example.web.repository.BesoinRepository;

@Service
public class BesoinService {

	@Autowired
	 BesoinRepository besoinRepository;
	
 public Besoin addBesoin (Besoin besoin) {
		
		return besoinRepository.save(besoin);
		
	} 
    public Besoin updateBesoin (Besoin besoin) {
		
		return besoinRepository.save(besoin);
		
	} 
     public Besoin getBesoin (Besoin besoin) {
		
		return besoinRepository.getOneBesoin(besoin.getId());
		
	} 
    
    public List<Besoin> getAllBesoins(){
		return besoinRepository.findAll();
	
    }
    
    public boolean deleteBesoin (final Long id) {
    	try {
    		besoinRepository.deleteById(id);
		return true;
    	}catch(Exception e) {
    		return false;
    		
    	}
    }
}
