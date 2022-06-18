package com.example.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Budget;
import com.example.web.model.Labo;
import com.example.web.repository.LaboRepository;

@Service
public class LaboService {

	@Autowired
	LaboRepository laboRepository;
	
	
	public Labo addLabo (Labo labo) {
		
		return laboRepository.save(labo);
		
	} 
    public Labo updateLabo (Labo labo) {
		
		return laboRepository.save(labo);
		
	} 
     public Labo getLabo (Labo labo) {
		
		return laboRepository.getOneLabo(labo.getId());
		
	} 
    
    public List<Labo> getAllLaboratoires(){
		return laboRepository.findAll();
	
    }
    
    public boolean deleteLabo (final Long id) {
    	try {
    		laboRepository.deleteById(id);
		return true;
    	}catch(Exception e) {
    		return false;
    		
    	}
    }
}
