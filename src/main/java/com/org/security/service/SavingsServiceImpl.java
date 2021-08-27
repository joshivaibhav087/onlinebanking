package com.org.security.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.security.model.SavingsAccount;
import com.org.security.model.SavingsRequest;
import com.org.security.model.TransferRequest;
import com.org.security.repository.SavingsRepository;


@Service
public class SavingsServiceImpl implements SavingsService {
	
	@Autowired
	SavingsRepository savingsRepository;

	
	@Override
	public SavingsAccount viewSavingsById(int id) {
		return savingsRepository.findById(id).get();
	}


	@Override
	public SavingsAccount depositSavings(SavingsRequest depositRequest) {
		SavingsAccount fetchedAccount = savingsRepository.findByAccountNumber(depositRequest.getAccountNumber());
		fetchedAccount.setAccountBalance(fetchedAccount.getAccountBalance().add(depositRequest.getAmount()));
		return savingsRepository.save(fetchedAccount);
	}


	@Override
	public SavingsAccount withdrawSavings(SavingsRequest withdrawRequest) {
		SavingsAccount fetchedAccount = savingsRepository.findByAccountNumber(withdrawRequest.getAccountNumber());
		fetchedAccount.setAccountBalance(fetchedAccount.getAccountBalance().subtract(withdrawRequest.getAmount()));
		return savingsRepository.save(fetchedAccount);
		}


	@Override
	public TransferRequest newFundsTransfer(TransferRequest transferRequest) {
		
		
		SavingsAccount recipient = savingsRepository.findByAccountNumber(transferRequest.getRecipientId());
		SavingsAccount origin = savingsRepository.findByAccountNumber(transferRequest.getOriginId());
		
	
		
		BigDecimal recipientBalance = recipient.getAccountBalance().add(transferRequest.getAmount());
		BigDecimal originBalance = origin.getAccountBalance().subtract(transferRequest.getAmount());

		recipient.setAccountBalance(recipientBalance);
		origin.setAccountBalance(recipientBalance);
		
		savingsRepository.save(recipient);
		savingsRepository.save(origin);
		
		
		return transferRequest;
	}


	@Override
	public SavingsAccount createSavingsAccount(SavingsAccount savings) {
		// TODO Auto-generated method stub
		 	return savingsRepository.save(savings);
	}


	@Override
	public SavingsAccount editSavingsAccount(SavingsAccount savings) {
		// TODO Auto-generated method stub
		return savingsRepository.save(savings);
	}




}
