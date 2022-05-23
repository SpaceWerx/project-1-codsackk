package com.revature.models;

public class Reimbursement {
	private int id;
	private int author;
	private int resolver;
	private String description;
	private Type type;
	private Status status;
	private int amount;
	
	
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}


	public Object getType() {
		// TODO Auto-generated method stub
		return type;
	}


	public Object getStatus() {
		// TODO Auto-generated method stub
		return status;
	}


	public int getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}


	public int getAuthor() {
		// TODO Auto-generated method stub
		return author;
	}


	public int getResolver() {
		// TODO Auto-generated method stub
		return resolver;
	}


	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
