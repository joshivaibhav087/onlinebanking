package com.org.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.security.model.TransferRequest;
import com.org.security.service.SavingsService;

@RestController
@RequestMapping("/api/transfers")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransferController {
	
	@Autowired
	SavingsService savingsService;
	
	@PostMapping("/new")
	public TransferRequest newFundsTransfer(@RequestBody TransferRequest transferRequest) {
		return savingsService.newFundsTransfer(transferRequest);
	}

}
