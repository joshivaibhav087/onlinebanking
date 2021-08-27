package com.org.security.service;

import org.springframework.stereotype.Service;

import com.org.security.model.SavingsAccount;
import com.org.security.model.SavingsRequest;
import com.org.security.model.TransferRequest;


@Service
public interface SavingsService {


	SavingsAccount viewSavingsById(int id);


	SavingsAccount withdrawSavings(SavingsRequest withdrawRequest);

	TransferRequest newFundsTransfer(TransferRequest transferRequest);

	SavingsAccount createSavingsAccount(SavingsAccount savings);

	SavingsAccount editSavingsAccount(SavingsAccount savings);


	SavingsAccount depositSavings(SavingsRequest depositRequest);

//	SavingsAccount deleteSavingsAccount(SavingsAccount savings);
	

}
