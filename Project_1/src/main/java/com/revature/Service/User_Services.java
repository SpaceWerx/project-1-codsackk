package com.revature.Service;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Roles;
import com.revature.models.Users;
import com.revature.repositories.UserDAO;

public class User_Services {
	
	static UserDAO uDAO = new UserDAO();
	
	public List<Users> getUsers() throws SQLException {
		
		List<Users> users =uDAO.getUsers();
		
		return users;
	}
	
	public void insertUser(Users newUser) throws SQLException {
		
		uDAO.insertUser(newUser);
		
	}
	
	public Users getUserById(int userId) {
		
		List<Users> userList = uDAO.getUserById(userId);
		try {
			Users user = userList.get(0);
			return user;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("no user found!");
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public static Users getUserByUsername(String username) {
		
		return UserDAO.getUsersByUsername(username);
		
		
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

	public List<Users> getUserByRole(Roles role) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
