package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Users;
import com.revature.utilities.ConnectionFactory;

public class UserDAO {
	
		public List<Users> getUsers() throws SQLException {
			try(Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from employees;";
				
				Statement s = conn.createStatement();
				
				rs = s.executeQuery(sql);
				
				List<Users> userList = new ArrayList<>();
				
				while(rs.next()) {
					Users u = new Users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getInt("role")				
							);
					userList.add(u);
				}
				return userList;
			}
			catch (SQLException u) {
				System.out.println("Something went wrong while getting users");
				u.printStackTrace();
				return null;
			}
		}

		public void insertUser(Users newUser) throws SQLException {
			try(Connection conn = ConnectionFactory.getConnection()){
				String sql = "insert into users (username, password, role) " + "values (?, ?, ?);";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, newUser.getUsername());
				ps.setString(2, newUser.getPassword());
				ps.setInt(3, newUser.getRole());
				
				ps.executeUpdate();
				
				System.out.println("Employee " + newUser.getUsername() + " was created. Welcome to the team!");
			}
			catch(SQLException u) {
				System.out.println("Something went wrong");
				u.printStackTrace();
			}
		}

		public List<Users> getUserById(int userId) {
			try(Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from users where user_id = ?;";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, userId);
				
				rs = ps.executeQuery();
				
				List<Users> userList = new ArrayList<>();
				
				while(rs.next()) {
					Users u = new Users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getInt("role")				
							);
					userList.add(u);
				}
				return userList;			
			}
			catch(SQLException u) {
				System.out.println("Something went wrong");
				u.printStackTrace();
				return null;
			}		
			
		}

		public List<Users> getUsersByRole(String role) {
			try(Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "select * from users where role = ?;";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, role);
				
				rs = ps.executeQuery();
				
				List<Users> userList = new ArrayList<>();
				
				while(rs.next()) {
					Users u = new Users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getInt("role")				
							);
					userList.add(u);
				}
				return userList;				
			}
			catch(SQLException u) {
				System.out.println("Something went wrong");
				u.printStackTrace();
				return null;
			}
		}
	}
