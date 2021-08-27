package com.org.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.security.model.SavingsAccount;
import com.org.security.model.SavingsRequest;
import com.org.security.service.SavingsService;

@RestController
@RequestMapping("/api/savings")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SavingsController {
	
	@Autowired
	SavingsService savingsService;
	
	
	@GetMapping("/view/{id}")
	public SavingsAccount viewSavingsById(@PathVariable int id) {
		return savingsService.viewSavingsById(id);
	}
	
	@PostMapping("/new")
	public SavingsAccount createSavingsAccount(@RequestBody SavingsAccount savings) {
		return savingsService.createSavingsAccount(savings);
	}
	
	@PutMapping("/edit")
	public SavingsAccount editSavingsAccount(@RequestBody SavingsAccount savings) {
		return savingsService.editSavingsAccount(savings);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public SavingsAccount deleteSavingsAccount(@RequestBody SavingsAccount savings) {
//		return savingsService.deleteSavingsAccount(savings);
//	}
	
	@PutMapping("/deposit")
	public SavingsAccount depositSavings(@RequestBody SavingsRequest depositRequest) {
	
				
		return savingsService.depositSavings(depositRequest);
	}
	
	@PutMapping("/withdraw")
	public SavingsAccount withdrawSavings(@RequestBody SavingsRequest withdrawRequest) {
		return savingsService.withdrawSavings(withdrawRequest);
	}

}
