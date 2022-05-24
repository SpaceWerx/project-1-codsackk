package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.Service.Auth_Service;

import io.javalin.http.Handler;

public class AuthenticationController {
	
Auth_Service as = new Auth_Service();
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		//I recommend you make this an employee object 
		Auth_Service log = gson.fromJson(body, Auth_Service.class);

		if(as.login(log.getUsername(), log.getPassword()) == 1) {
			ctx.status(201);
			ctx.result("Login Sucessful!");
		}
		else if(as.login(log.getUsername(), log.getPassword()) == 2) {
			ctx.status(202);
			ctx.result("Login Sucessful!");
		}
		else {
		ctx.result("Login Failed!");
		ctx.status(401);
		}
	};
	
}
