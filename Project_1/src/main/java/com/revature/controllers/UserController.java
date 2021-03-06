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



	

}
