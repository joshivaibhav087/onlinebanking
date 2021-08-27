package com.org.security.model;

import java.math.BigDecimal;

public class SavingsRequest {
	
	private int id;
	private int accountNumber;
	private BigDecimal amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public SavingsRequest(int id, int accountNumber, BigDecimal amount) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public SavingsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
