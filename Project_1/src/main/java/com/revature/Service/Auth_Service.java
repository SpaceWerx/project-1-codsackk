package com.revature.Service;

import com.revature.models.Users;

public class Auth_Service {
	//making a new user object
	public int register(Users userToBeRegistered) {
		
		//checking if the username already exists in the database
		// if the method returns null, the username is unavailable 
		if(userDAO.getUserByUsername(userToBeRegistered.getUsername()) !=null) {
			
			
			//throws a nullpointerexception if the username is already taken
			throw new NullPointerException("Username is already taken!");
		}
		
		// take in the user object sent from the menu and send it to the userDAO to be inserted into the database
		//Afte the entry has been made, the id of the new user is immediately returned
		return userDAO.create(userToBeRegistered);
	}
	
	public Users login(String username, String password) {
		Users user;
		
		try {
			
			user = userDAO.getUserByUsername(username);
			
			if(user!=null && password.equals(user.getPassword())) {
				
				System.out.println("You logged in successfully!");
				return user;
			
			} else if (user!=null && !password.equals(user.getPassword())) {
				
				System.out.println("Wrong password.");
				return null;
			
			} else {
				System.out.println("User does not exist!");
				return null; 
			}
		
		} catch (Exception e) {
			System.out.println("Login unsuccessful!");
			e.printStackTrace(); //helpful debugging tool
		}
		
		return null; 
		}
	
}
