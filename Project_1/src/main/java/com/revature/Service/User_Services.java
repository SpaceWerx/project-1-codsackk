package com.revature.Service;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Users;
import com.revature.repositories.UserDAO;

public class User_Services {
	
	UserDAO uDAO = new UserDAO();
	
	public List<Users> getUsers() throws SQLException {
		
		List<Users> users =uDAO.getUsers();
		
		return users;
	}
	
	public void insertUser(Users newUser) throws SQLException {
		
		uDAO.insertUser(newUser);
		
	}
	
	public List<Users> getUserById(int userId) {
		
		List<Users> user = uDAO.getUserById(userId);
		
		return user;
		
	}
	
	public List<Users> getUserByUsername(String username) {
		
		List<Users> user = uDAO.getUsersByUsername(username);
		
		return user;
		
	}
	
	public boolean userExistsById(int id) throws SQLException {
		for(Users users : uDAO.getUsers()) {
			if(users.getUserById()==id) {
				System.out.println("this ID exists!");
				break;
			}
		}
		
		System.out.println("this ID does not exist");
		return false;
	}
	
}
