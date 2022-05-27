package com.revature.controllers;

import com.revature.Service.Reimbursement_Services;
import com.revature.Service.User_Services;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.repositories.ReimbursementDAO;

import java.util.List;

import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;

public class ReimbursementController {
	
	ObjectMapper objectMapper = new ObjectMapper();
	Reimbursement_Services reimbursementService = new Reimbursement_Services();
	User_Services userService = new User_Services();
	
	
	public Handler getReimbursementsHandler = (ctx) -> {
		
		List<Reimbursement> allReimbursements = ReimbursementDAO.getAllReimbursements();
		
		Gson gson = new Gson();
		
		String JSONObject = gson.toJson(allReimbursements);
		
		ctx.result(JSONObject);
		ctx.status(200);

	};
	
	public Handler submitReimbursementsHandler = (ctx) -> {
			
			String body =ctx.body();
			Gson gson = new Gson();
		
			Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
			
			int id = Reimbursement_Services.submitReimbursement(reimbursement);
			
			if(id !=0) {
				ctx.status(HttpCode.CREATED);
				ctx.result(""+id);
			} else {
				ctx.status(HttpCode.BAD_REQUEST);
				ctx.result("Reimbursement submission was unsuccessful!");
				
		}
			
	};	
	
	public Handler handleApproved = (ctx) ->{
		 
		String body = ctx.body();
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		int id = reimbursement.getResolver();

		Reimbursement processedReimbursement = Reimbursement_Services.update(reimbursement); 
		if(processedReimbursement != null){
		ctx.status(HttpCode.ACCEPTED);


		} else {
				ctx.status(HttpCode.ACCEPTED);
				ctx.result("Reimbursement processing was not successful");
			}
		

	};

	public Handler handleDenied = (ctx) ->{
		 
		String body = ctx.body();
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		int id = reimbursement.getResolver();

		Reimbursement processedReimbursement = Reimbursement_Services.update(reimbursement); 
		if(processedReimbursement != null){
		ctx.status(HttpCode.ACCEPTED);


		} else {
				ctx.status(HttpCode.ACCEPTED);
				ctx.result("Reimbursement processing was not successful");
			}
		

	};
	
}	
	

	

