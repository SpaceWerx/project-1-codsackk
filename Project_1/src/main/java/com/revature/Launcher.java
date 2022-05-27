package com.revature;

import com.revature.controllers.UserController;
import com.revature.controllers.AuthenticationController;
import com.revature.controllers.ReimbursementController;
//import java.util.Scanner;
import com.revature.utilities.ConnectionFactory;

import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
	
	
	public static void main(String[] args) throws SQLException {
			
			UserController uc = new UserController();
			AuthenticationController ac = new AuthenticationController();
			ReimbursementController rc = new ReimbursementController();
			
			//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
			try(Connection conn = ConnectionFactory.getConnection()){
				System.out.println("Connection Successful :)");
			} catch(SQLException e) {
				System.out.println("Connection failed");
				e.printStackTrace();
			}	

		
			//Make the menu	run, its only 2 lines of code	
			//Menu menu = new Menu();
				
			//menu.printMenu();
			
			Javalin app = Javalin.create(
				config-> {
					config.enableCorsForAllOrigins();
				}
					).start(3000);
		
			app.post("/login", ac.loginHandler);
			
			app.post("/register", ac.registerHandler);
			
			app.get("/user", uc.getUsersHandler);
			
			app.post("/user", uc.insertUsersHandler);
			
			app.get("/reimbursement", rc.getReimbursementsHandler);
			
			app.post("/reimbursement", rc.submitReimbursementsHandler);
			
			app.put("/approved", rc.handleApproved);
			
			app.put("/denied", rc.handleDenied);
		}

	}


