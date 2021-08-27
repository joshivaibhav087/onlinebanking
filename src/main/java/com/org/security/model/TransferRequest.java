package com.org.security.model;

import java.math.BigDecimal;

public class TransferRequest {
	
	private int id;
	private int recipientId;
	private int originId;
	private BigDecimal amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}
	public int getOriginId() {
		return originId;
	}
	public void setOriginId(int originId) {
		this.originId = originId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public TransferRequest(int id, int recipientId, int originId, BigDecimal amount) {
		super();
		this.id = id;
		this.recipientId = recipientId;
		this.originId = originId;
		this.amount = amount;
	}
	public TransferRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransferRequest [id=" + id + ", recipientId=" + recipientId + ", originId=" + originId + ", amount="
				+ amount + "]";
	}
	
	

}
