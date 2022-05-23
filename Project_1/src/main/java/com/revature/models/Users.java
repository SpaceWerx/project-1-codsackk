package com.revature.models;

public class Users {
	private int user_id;
	private String username;
	private String password;
	private int role;
	
	public Users(int int1, String string, String string2, int int2) {
		// TODO Auto-generated constructor stub
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
