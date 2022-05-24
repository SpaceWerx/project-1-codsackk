package com.revature.models;

import java.util.Objects;

public class Users {
	
	private int user_id;
	private String username;
	private String password;
	private Roles role;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(int user_id, String username, String password, Roles role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	
	public int getUserById() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(password, role, user_id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(password, other.password) && role == other.role && user_id == other.user_id
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
}
