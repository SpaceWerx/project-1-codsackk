package com.revature.Service;

import java.sql.SQLException;

import com.revature.models.Roles;
import com.revature.models.Users;
import com.revature.repositories.UserDAO;

public class Auth_Service {
	
	public static int register(Users userToBeRegistered) throws SQLException {
		
		if(UserDAO.getUsersByUsername(userToBeRegistered.getUsername()) != null) {
			
			throw new NullPointerException("Username is already taken");
		}
	
		return UserDAO.insertUser(userToBeRegistered);
	}
	


	public static int login(String username, String password) {
		

		
		try {
			
			Users user = (Users) UserDAO.getUsersByUsername(username);
			
			if(user!=null && password.equals(user.getPassword()) && user.getRole()== Roles.MANAGER) {
				
				System.out.println("Manager Logged In Successfully!");
				return 1;
			} else if (user!=null && password.equals(user.getPassword()) && user.getRole()== Roles.EMPLOYEE) {
				
				System.out.println("Employee Logged In Successfully!");
				return 2;
			} else {
				
				System.out.println("Username or Password Does Not Exist!");
//				return 0;
			}
		} catch (Exception e) {
			System.out.println("Login Unsuccessful");
			e.printStackTrace();
		}
		return 0;
		
		
		
	}

	public static Object login(int anyInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object update(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
	

