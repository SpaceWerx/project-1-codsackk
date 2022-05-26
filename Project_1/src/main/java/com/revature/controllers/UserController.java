package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.Service.User_Services;
import com.revature.models.Users;

import io.javalin.http.Handler;

public class UserController {
	
	User_Services us = new User_Services();

	public Handler getUsersHandler = (ctx) -> {
		
		List<Users>	allUsers = us.getUsers();
		
		Gson gson = new Gson();
		
		String JSONObject = gson.toJson(allUsers);
		
		ctx.result(JSONObject);
		ctx.status(200);
		
	};
	
	
	public Handler insertUsersHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Users user = gson.fromJson(body, Users.class);
		
		us.insertUser(user);
		
		ctx.result("User added successfully!");
		ctx.status(201);
		
	};

	public Handler getUserByUsernameHandler = (ctz -> {
		
		
		
	});

	

//	public Handler getUserByUsernameHandler = (ctx) -> {
//		
//		List<Users> username = us.getUserByUsername();
//		
//		Gson gson = new Gson();
//		
//		String JSONObject = gson.toJson(username);
//		
//		ctx.result(JSONObject);
//		ctx.status(200);
//		
//		
//	};
//	
	public Handler getUserByIdHandler;
	
//	public Handler getUserByIdHandler = (ctx) -> {
//		
//		List<Users> userId = us.getUserById();
//		
//		Gson gson = new Gson();
//		
//		String JSONObject = gson.toJson(userId);
//		
//		ctx.result(JSONObject);
//		ctx.status(200);
//		
//		
//	};

}
