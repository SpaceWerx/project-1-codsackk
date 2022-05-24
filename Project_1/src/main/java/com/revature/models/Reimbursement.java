package com.revature.models;

import java.util.Objects;

public class Reimbursement {
	private int reimbursements_id;
	private int author;
	private int resolver;
	private String description;
	private Type type;
	private Status status;
	private float amount;
	
	
	

	public Reimbursement(int reimbursements_id, int author, int resolver, String description, Type type, Status status,
			float amount) {
		super();
		this.reimbursements_id = reimbursements_id;
		this.author = author;
		this.resolver = resolver;
		this.description = description;
		this.type = type;
		this.status = status;
		this.amount = amount;
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
	

	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}


	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, reimbursements_id, resolver, status, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Float.floatToIntBits(amount) == Float.floatToIntBits(other.amount) && author == other.author
				&& Objects.equals(description, other.description) && reimbursements_id == other.reimbursements_id
				&& resolver == other.resolver && status == other.status && type == other.type;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursements_id=" + reimbursements_id + ", author=" + author + ", resolver=" + resolver
				+ ", description=" + description + ", type=" + type + ", status=" + status + ", amount=" + amount + "]";
	}
	
	

}
