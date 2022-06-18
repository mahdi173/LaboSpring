package com.example.web.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.web.model.Budget;
import com.example.web.model.Labo;
import com.example.web.model.Membre;
import com.example.web.repository.BudgetRepository;
import com.example.web.repository.MembreRepository;

@Service
public class MembreService {

	@Autowired
	 MembreRepository membreRepository;
	
	@Autowired
	 BudgetRepository budgetRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 public Membre addMembre (Membre membre) {
		 membre.setEnabled(true);
		 membre.setPassword(passwordEncoder.encode(membre.getPassword()));

			return membreRepository.save(membre);
			
		} 
	    public Membre updateMembre (Membre newMembre) {
			
	    	Budget labBudget= new Budget();
	    	Membre oldMembre= new Membre();
    		double rest;
	    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
	    	Date d= new Date();
	    	
	    	labBudget=budgetRepository.getByYear(Integer.parseInt(sdf.format(d)));
	    	oldMembre= membreRepository.getOneMembre(newMembre.getId());
	    	
	    	if(oldMembre.getBudget()<newMembre.getBudget()) { // s'il a donné un nouveau budget qui est supérieur à l'ancien budget du membre=> soustraire le montant ajouté de la dotation de recherche
	    	    rest= newMembre.getBudget() - oldMembre.getBudget();
	    	    labBudget.setDotationRecherche(labBudget.getDotationRecherche()-rest);
	    	    budgetRepository.save(labBudget);
	    	    
	    	}else if(oldMembre.getBudget()>newMembre.getBudget()){ //s'il a donné un nouveau budget qui est inférieur à l'ancien budget du membre=> ajout de montant à la dotation de recherche
	    		rest= oldMembre.getBudget() - newMembre.getBudget();
	    	    labBudget.setDotationRecherche(labBudget.getDotationRecherche()+rest);	
	    	    budgetRepository.save(labBudget);
	    	}
			   return membreRepository.save(newMembre);

		} 
	    
	     public Membre getMembre (Membre membre) {
			
			return membreRepository.getOneMembre(membre.getId());
			
		} 
	    
	    public List<Membre> getAllMembres(){
			return membreRepository.getAllActiveMembres();
		
	    }
	    
	    public boolean deleteMembre (Membre m) {
	    	Budget labBudget= new Budget();
	    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
	    	Date d= new Date();
	    	labBudget=budgetRepository.getByYear(Integer.parseInt(sdf.format(d)));	    	
	    	labBudget.setDotationRecherche(labBudget.getDotationRecherche()+ m.getBudget());
	    	
	    	try {
	    		m.setEnabled(false);
		        budgetRepository.save(labBudget);
	    		membreRepository.save(m);
			return true;
	    	}catch(Exception e) {
	    		System.out.println(e.getMessage()); 
	    		System.out.println(e.getCause()); 

	    		return false;
	    		
	    	}
	    }
}
