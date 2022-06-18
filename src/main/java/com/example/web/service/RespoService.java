package com.example.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.web.model.Responsable;
import com.example.web.repository.ResponsableRepository;

@Service
public class RespoService {
	
	@Autowired
	 ResponsableRepository respoRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Responsable> getAllRespos(){
		return respoRepository.findAll();
		}
	
	 public Responsable save (Responsable r) {
		 
		 r.setPassword(passwordEncoder.encode(r.getPassword()));

			return respoRepository.save(r);
			
		} 
	    public Responsable update(Responsable r) {
			
			return respoRepository.save(r);
			
		} 
	   
	    
	    public boolean delete(final Long id) {
	    	try {
	    		respoRepository.deleteById(id);
			return true;
	    	}catch(Exception e) {
	    		return false;
	    		
	    	}
	    }

}
