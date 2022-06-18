package com.example.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Budget;
import com.example.web.repository.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
    BudgetRepository budgetRepository;
	
	public Budget addBudget (Budget budgetNew) {
		
		return budgetRepository.save(budgetNew);
		
	} 
    public Budget updateBudget (Budget budget) {
		
		return budgetRepository.save(budget);
		
	} 
     public Budget getBudget (Budget newBudget ) {
		
		return budgetRepository.getOneBudget(newBudget.getId());
		
	} 
    
    public List<Budget> getAllBudgets(){
    	
		return budgetRepository.findAll();
	
    }
    
    public boolean deleteBudget (final Long id) {
    	try {
    	budgetRepository.deleteById(id);
		return true;
    	}catch(Exception e) {
    		return false;
    		
    	}
    }
	public Budget getBudgetByYear(int year) {
	   return budgetRepository.getByYear(year);	
	}
}

