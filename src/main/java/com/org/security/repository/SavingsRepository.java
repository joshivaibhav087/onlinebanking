package com.org.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.security.model.SavingsAccount;

import antlr.collections.List;

@Repository
public interface SavingsRepository extends JpaRepository<SavingsAccount, Integer> {
	
	public SavingsAccount findByAccountNumber(int accountNumber);
	
	

}
