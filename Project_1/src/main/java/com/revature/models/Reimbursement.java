package com.revature.models;

public class Reimbursement {
	private int reimbursements_id;
	private int author;
	private int resolver;
	private String description;
	private String type;
	private String status;
	private float amount;
	
	
	public Reimbursement(int reimbursements_id, int author, int resolver, String description, Type valueOf, Status valueOf2, float amount) {
		
	}

	public int getReimbursementsId() {
		return reimbursements_id;
	}
	
	public void setReimbursementsId(int reimbursements_id) {
		this.reimbursements_id = reimbursements_id;
	}
	
	public int getAuthor() {
		return author;
	}
	
	public void setAuthor(int author) {
		this.author = author;
	}
	
	public int getResolver() {
		return resolver;
	}
	
	public void setResolver(int resolver) {
		this.resolver = resolver;		
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}


	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
