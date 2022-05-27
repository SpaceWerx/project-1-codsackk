package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Roles;
import com.revature.models.Users;
import com.revature.utilities.ConnectionFactory;

public class UserDAO {
	
		public List<Users> getUsers() throws SQLException {
			try(Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "SELECT * FROM users;";
				
				Statement s = conn.createStatement();
				
				rs = s.executeQuery(sql);
				
				List<Users> userList = new ArrayList<>();
				
				while(rs.next()) {
					Users u = new Users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							Roles.valueOf(rs.getString("role"))				
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

		public static int insertUser(Users newUser) throws SQLException {
			try(Connection conn = ConnectionFactory.getConnection()){
				String sql = "INSERT INTO users (username, password, role) " + "VALUES (?, ?, ?);";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, newUser.getUsername());
				ps.setString(2, newUser.getPassword());
				ps.setString(3, newUser.getRole().name());
				
				ps.executeUpdate();
				
				System.out.println("Employee " + newUser.getUsername() + " was created. Welcome to the team!");
			}
			catch(SQLException u) {
				System.out.println("Something went wrong");
				u.printStackTrace();
			}
			return 0;
		}

		public List<Users> getUserById(int userId) {
			try(Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "SELECT * FROM users WHERE user_id = ?;";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, userId);
				
				rs = ps.executeQuery();
				
				List<Users> userList = new ArrayList<>();
				
				while(rs.next()) {
					Users u = new Users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							Roles.valueOf(rs.getString("role"))				
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

		public static List<Users> getUsersByUsername(String username) {
			try(Connection conn = ConnectionFactory.getConnection()){
				ResultSet rs = null;
				
				String sql = "SELECT * FROM users WHERE username = ?;";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, username);
				
				rs = ps.executeQuery();
				
				List<Users> userList = new ArrayList<>();
				
				while(rs.next()) {
					Users u = new Users(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							Roles.valueOf(rs.getString("role"))				
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
