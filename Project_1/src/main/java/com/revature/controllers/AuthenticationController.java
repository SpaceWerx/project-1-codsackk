package com.revature.controllers;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.Service.Auth_Service;
import com.revature.models.Users;

import io.javalin.http.Handler;
import io.javalin.http.HttpCode;

public class AuthenticationController {
	
Auth_Service as = new Auth_Service();

	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		//I recommend you make this an employee object 
		Users log = gson.fromJson(body, Users.class);

		if(Auth_Service.login(log.getUsername(), log.getPassword()) == 1) {
			ctx.status(201);
			ctx.result("Login Sucessful!");
		}
		else if(Auth_Service.login(log.getUsername(), log.getPassword()) == 2) {
			ctx.status(202);
			ctx.result("Login Sucessful!");
		}
		else {
		ctx.result("Login Failed!");
		ctx.status(401);
		}
	};
	
	ObjectMapper Mapper = new ObjectMapper();

	public Handler registerHandler = (ctx) -> {
		
		try {
			
			String input = ctx.body();
			
			Users user = Mapper.readValue(input, Users.class);
			
			int id = Auth_Service.register(user);
			
			if(id == 0) {
				
				ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
				ctx.result("Registration unsuccessful.");
			}
			
		} catch (Exception e) {
			
			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			
			if(!e.getMessage().isEmpty()) {
				ctx.result(e.getMessage());
			}
			
			e.printStackTrace();
		}
	};	
}
