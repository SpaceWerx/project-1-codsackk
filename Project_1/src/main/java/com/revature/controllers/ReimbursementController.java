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
	
		
	
	public void handleProcess(Context ctx) {
		
		String authHeader = ctx.header("Current-User");
		
		if(authHeader != null) {
			
			int userId = Integer.parseInt(authHeader);
			
			try{
				
				String reimbursementIdInput = ctx.pathParam("id");
				
				int id = Integer.parseInt(reimbursementIdInput);
				
				String statusInput = ctx.formParam("status");
				
				Reimbursement reimbursement = reimbursementService.getReimbursementById(id);
				
				if(reimbursement != null) {
					
					Reimbursement processedReimbursement = reimbursementService.update(reimbursement, userId, Status.valueOf(statusInput));
					
					ctx.status(HttpCode.ACCEPTED);
					ctx.json(processedReimbursement);
				
				
				} else {
					
					ctx.status(HttpCode.BAD_REQUEST);
					ctx.result("Reimbursement processing was not successful!");
				}
				
				
			} catch(Exception e) {
			
				ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
				
				
				if(!e.getMessage().isEmpty()) {
					ctx.result(e.getMessage());
			}
			
				e.printStackTrace();
		}
		
	
	} else {
		
		ctx.status(HttpCode.FORBIDDEN);
		ctx.result("Missing current user header with ID");
			
		}
	}

	
	
	public void handleGetReimbursementsByStatus(Context ctx) {
		
		try {
			
			String statusParam = ctx.queryParam("status");
			
			Status status = Status.valueOf(statusParam);
			
			if(status == Status.PENDING) {
				
				ctx.status(HttpCode.OK);
				ctx.json(reimbursementService.getPendingReimbursements());
				
			} else {
				
				ctx.status(HttpCode.OK);
				ctx.json(reimbursementService.getResolvedReimbursements());
			}
			
		} catch(Exception e) {
			
			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			
			if(!e.getMessage().isEmpty()) {
				ctx.result(e.getMessage());
			}
			
			e.printStackTrace();
			
			
		}
		
	}
	
	public void handleGetReimbursementsById(Context ctx) {
		
		try {
			
			String idParam = ctx.pathParam("id");
			
			int id = Integer.parseInt(idParam);
			
			Reimbursement reimbursement = reimbursementService.getReimbursementById(id);
			
			if(reimbursement != null) {
				
				ctx.status(HttpCode.OK);
				ctx.json(reimbursement);
				
			} else {
				
				ctx.status(HttpCode.BAD_REQUEST);
				ctx.result("Could not retrieve the reimbursement!");
			}
			
		} catch(Exception e) {
			
			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
			
			if(!e.getMessage().isEmpty()) {
				ctx.result(e.getMessage());
			}
			
			e.printStackTrace();
			
			
		}
		
	}
}
//	
//	public void handleGetReimbursementsByAuthor(Context ctx) {
//					ctx.json(reimbursementService.getResolvedReimbursements());
//				}
//				
//			} else {
//				
//				ctx.status(HttpCode.BAD_REQUEST);
//				ctx.result("Missing Current User Header!");
//				
//			}
//			
//		} catch(Exception e) {
//			
//			ctx.status(HttpCode.INTERNAL_SERVER_ERROR);
//			
//			
//		try {
//			
//			String idParam = ctx.queryParam("author");
//			
//			if(idParam != null) {
//				
//				int id = Integer.parseInt(idParam);
//				
//				if(userService.userExistsById(id)) {
//					
//					ctx.status(HttpCode.OK);
//					ctx.result("Unable to retrieve reimbursements, current user is not in the database!");
//					
//				} else {
//					
//					ctx.status(HttpCode.NOT_FOUND);
//		if(!e.getMessage().isEmpty()) {
//				ctx.result(e.getMessage());
//			}
//			
//			e.printStackTrace();
//			
//			
//		}
//		
//	}
//
//}
	

