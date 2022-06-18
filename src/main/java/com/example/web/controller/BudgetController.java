package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Budget;
import com.example.web.service.BudgetService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BudgetController {
	
	@Autowired
	BudgetService  budgetService;
	
	@GetMapping("/budgets/index")
	List<Budget>  storeBudget()  {
		return budgetService.getAllBudgets();		
	}
	@PostMapping("/budgets/create")
	ResponseEntity storeBudget(@RequestBody Budget newBudget)  {
		  Budget budget = budgetService.addBudget(newBudget);
		if(budget != null) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity( HttpStatus.BAD_REQUEST);
			}
	}
	
	@PutMapping("/budgets/edit")
	ResponseEntity editBudget(@RequestBody Budget newBudget)  {
		  Budget budget = budgetService.updateBudget(newBudget);
		
		  if(budget != null) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity( HttpStatus.BAD_REQUEST);
			}
	}
	@GetMapping("/budgets/show")
	ResponseEntity<Budget>  showBudget(@RequestBody Budget newBudget)  {
		  Budget budget = budgetService.getBudget(newBudget);
		
		  if(budget != null) {
			
			 return new ResponseEntity<Budget>(budget, HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	}
	
	@PostMapping("/budgets/delete")
	ResponseEntity deleteBudget(@RequestBody Budget newBudget)  {
		 
		
		  if(budgetService.deleteBudget(newBudget.getId())) {
			
			 return new ResponseEntity( HttpStatus.OK);
				
			}else {
				return new ResponseEntity( HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping("/budgets/{year}")
	public Budget getBudget(@PathVariable  int year)  {
		 
		return budgetService.getBudgetByYear(year);
		
	}

}
